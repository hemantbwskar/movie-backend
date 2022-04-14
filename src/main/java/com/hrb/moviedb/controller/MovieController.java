package com.hrb.moviedb.controller;

import java.net.MalformedURLException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrb.moviedb.model.Movie;
import com.hrb.moviedb.service.MovieService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MovieController {

	@Autowired
	public MovieService movieService;

	@GetMapping("/movies")
	public List<Movie> getMovies() {
		return movieService.getMovies();

	}

	@GetMapping("/")
	public String Hello() {
//		movieService.addData();
		return "Helloworld";

	}
	
	@GetMapping("/movie/{movieId}")
	public Movie getMovieById(@PathVariable int movieId) {
		return movieService.getMovieById(movieId);
	}
	
//	@GetMapping("/add-movies")
//	public String addMovies(){
//		movieService.addData();
//		return "Movies added";
//		
//	}
	
	@GetMapping("/search")
	public List<Movie> searchMovie(@RequestParam(required = false) String title, @RequestParam String ordering) {

		return movieService.searchMovies(title, ordering);

	}

	@PostMapping("/add-movie")
	public Movie saveMovie(@RequestBody Movie movie) {

		return movieService.saveMovie(movie);

	}
	
	
	

}
