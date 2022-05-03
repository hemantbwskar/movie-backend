package com.hrb.moviedb.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrb.moviedb.models.Movie;
import com.hrb.moviedb.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
//	@SuppressWarnings("unchecked")
//	public void addData(){
//	
//	 JSONParser jsonParser = new JSONParser();
////	 
////	 File file = new File("/target/MovieDB-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes/movies.json");
////	 for(String fileNames : file.list()) System.out.println(fileNames);
//     
////	 URL inputFilePath =new URL("github.com/hemantbwskar/movie-db-frontend/blob/main/src/input.json") ;
////	 URL resource = getResource(inputFilePath);
////	   File path is passed as parameter
////	 File file = new File("https://github.com/hemantbwskar/movie-db-frontend/blob/main/src/input.json");
//     try (FileReader reader = new FileReader("/target/MovieDB-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes/movies.json"))
//     {
//         //Read JSON file
//         Object obj = jsonParser.parse(reader);
//
//         JSONArray movieList = (JSONArray) obj;
////         System.out.println(movieList);
//          
//         //Iterate over employee array
//         movieList.forEach(
//        				 movie -> movieRepository.save(convertMovie( (JSONObject) movie )));
////        				 movie -> System.out.println(movie));
//
//     } catch (FileNotFoundException e) {
//         e.printStackTrace();
//     } catch (IOException e) {
//         e.printStackTrace();
//     } catch (ParseException e) {
//         e.printStackTrace();
//     }
// }
//	
//	public Movie convertMovie(JSONObject movie) {
//		
//		JSONObject movieObject = (JSONObject) movie.get("movie");
//		
//	Movie movieData=new Movie();
//	
//	
////	movie.setMovieId((int) movieObject.get("movieId"));
//	movieData.setBackgroundImage((String) movieObject.get("backgroundImage"));
//	movieData.setTitle((String) movieObject.get("title"));
//    movieData.setReleased((String) movieObject.get("released"));
//    movieData.setMetacritic_url((String) movieObject.get("metacritic_url"));
//    movieData.setWebsite((String) movieObject.get("website"));
//    movieData.setDescription((String) movieObject.get("description"));
//    movieData.setMetacritic((String) movieObject.get("metacritic"));
//    movieData.setGenres((ArrayList<String>) movieObject.get("genres"));
//    movieData.setPlatforms((ArrayList<String>) movieObject.get("platforms"));
//    movieData.setRatings((ArrayList<String>) movieObject.get("ratings"));
//    movieData.setScreenshots((ArrayList<String>) movieObject.get("screenshots"));
//    movieData.setTrailers((ArrayList<String>) movieObject.get("trailers"));
//    movieData.setPoster((String) movieObject.get("poster"));
//    
//    return movieData;
//	}

	

	public List<Movie> getMovies() {
		return movieRepository.findAll();

	}

	public Movie saveMovie(Movie movie) {

		return movieRepository.save(movie);

	}

	public List<Movie> searchMovies(String title, String ordering) {
		
		Sort sort = Sort.by(ordering).ascending();

//		switch (ordering) {
//		case "ratings":
//			return movieRepository.findByTitleOrderByRatingsAsc(title==null?"":title);
//		case "metacritic":
//			return movieRepository.findByTitleOrderByMetacriticAsc(title==null?"":title);
//		case "released":
//			return movieRepository.findByTitleOrderByReleasedAsc(title==null?"":title);
//		case "name":
//			return movieRepository.findByTitleOrderByTitleAsc(title==null?"":title.toUpperCase(),sort);
//		default:
			return movieRepository.findByTitleOrderByTitleAsc(title==null?"":title.toUpperCase(),sort);
//		}

	}

	public List<Movie> saveAllMovie(List<Movie> movies) {
		
		return movieRepository.saveAll(movies);
	}

	public Movie getMovieById(int id) {
		
		return movieRepository.getByMovieId(id);
	}

}
