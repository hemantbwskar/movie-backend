package com.hrb.moviedb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrb.moviedb.model.Movie;
import com.hrb.moviedb.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getMovies() {
		return movieRepository.findAll();

	}

	public Movie saveMovie(Movie movie) {

		return movieRepository.save(movie);

	}

	public List<Movie> searchMovies(String title, String ordering) {

		switch (ordering) {
		case "ratings":
			return movieRepository.findByTitleOrderByRatingsAsc(title==null?"":title);
		case "metacritic":
			return movieRepository.findByTitleOrderByMetacriticAsc(title==null?"":title);
		case "released":
			return movieRepository.findByTitleOrderByReleasedAsc(title==null?"":title);
		case "name":
			return movieRepository.findByTitleOrderByTitleAsc(title==null?"":title);
		default:
			return movieRepository.findByTitleOrderByTitleAsc(title==null?"":title);
		}

	}

}
