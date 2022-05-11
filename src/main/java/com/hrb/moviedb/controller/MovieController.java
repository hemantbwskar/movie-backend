package com.hrb.moviedb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hrb.moviedb.models.AuthenticationRequest;
import com.hrb.moviedb.models.AuthenticationResponse;
import com.hrb.moviedb.models.Movie;
import com.hrb.moviedb.models.MyUser;
import com.hrb.moviedb.service.MovieService;
import com.hrb.moviedb.service.MyUserDetailService;
import com.hrb.moviedb.util.JwtUtil;

@CrossOrigin
@RestController
public class MovieController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	public MovieService movieService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e){
			throw new Exception("Incorrect Username or Password",e);
		}
		final UserDetails userDetails=userDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt=jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@PostMapping("/authenticate/signup")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void saveUserDetails(@RequestBody MyUser myUser) throws Exception{
		
		if(userDetailService.existingUserName(myUser.getUsername())) {
			throw new Exception("Username Already Exists!");
//			return ResponseEntity.badRequest()
//					.body("Username already Exists");
		}
		if(userDetailService.existingEmail(myUser.getEmailId())) {
			throw new Exception("EmailId Already Exists!");
//			return ResponseEntity.badRequest()
//					.body("Email already Exists");
		}
		
		MyUser user=  userDetailService.saveUserDetails(myUser);
		System.out.println(user.toString());
	}

	@GetMapping("/")
	public String Hello() {
		return "Helloworld";

	}

	@GetMapping("/movies")
	public List<Movie> getMovies() {
		return movieService.getMovies();

	}

	@GetMapping("/movie/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable int movieId) {
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Access-Control-Allow-Origin", 
	      "*");
	    
		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body(movieService.getMovieById(movieId));
	}

	@GetMapping("/search")
	public List<Movie> searchMovie(@RequestParam(required = false) String title, @RequestParam String ordering) {

		return movieService.searchMovies(title, ordering);

	}

	@PostMapping("/add-movie")
	public Movie saveMovie(@RequestBody Movie movie) {

		return movieService.saveMovie(movie);

	}
	
	@GetMapping("/user")
	public ResponseEntity<MyUser> getUser(@RequestParam String username){
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Access-Control-Allow-Origin", 
	      "*");
		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body(userDetailService.getUser(username));
	}

}
