package com.hrb.moviedb;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrb.moviedb.service.MovieService;
import com.hrb.moviedb.model.Movie;

@SpringBootApplication
public class MoviedbApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoviedbApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(MovieService movieService) {
		return args->{
			ObjectMapper mapper=new ObjectMapper();
			TypeReference<List<Movie>> typeReference=new TypeReference<List<Movie>>(){};
			InputStream inputStream=TypeReference.class.getResourceAsStream("/json/movies.json");
			try {
				List<Movie> movies=mapper.readValue(inputStream, typeReference);
				movieService.saveAllMovie(movies);
				System.out.println("Movies added");
			}catch(IOException e){
				System.out.println("unable to save Movies: "+e.getMessage());
			}
		};
	}

}
