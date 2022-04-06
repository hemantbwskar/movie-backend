package com.hrb.moviedb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrb.moviedb.model.Movie;
import com.hrb.moviedb.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	public MovieService movieService;

	@GetMapping("/movies")
	public List<Movie> getMovies() {
		return movieService.getMovies();

	}

	@GetMapping("/search")
	public List<Movie> searchMovie(@RequestParam(required = false) String title, @RequestParam String ordering) {

		return movieService.searchMovies(title, ordering);

	}

	@PostMapping("/movies")
	public Movie saveMovie(@RequestBody Movie movie) {

		return movieService.saveMovie(movie);

	}

}
