package com.hrb.moviedb.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String backgroundImage;
	private String title;
    private String released;
    private String metacritic_url;
    private String website;
    private String description;
    private String metacritic;
    private ArrayList<String> genres;
    private ArrayList<String> platforms;
    private ArrayList<String> ratings;
    private ArrayList<String> screenshots;
    private ArrayList<String> trailers;
    private String poster;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getBackgroundImage() {
		return backgroundImage;
	}
	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getMetacritic_url() {
		return metacritic_url;
	}
	public void setMetacritic_url(String metacritic_url) {
		this.metacritic_url = metacritic_url;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMetacritic() {
		return metacritic;
	}
	public void setMetacritic(String metacritic) {
		this.metacritic = metacritic;
	}
	public ArrayList<String> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}
	public ArrayList<String> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(ArrayList<String> platforms) {
		this.platforms = platforms;
	}
	public ArrayList<String> getRatings() {
		return ratings;
	}
	public void setRatings(ArrayList<String> ratings) {
		this.ratings = ratings;
	}
	public ArrayList<String> getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(ArrayList<String> screenshots) {
		this.screenshots = screenshots;
	}
	public ArrayList<String> getTrailers() {
		return trailers;
	}
	public void setTrailers(ArrayList<String> trailers) {
		this.trailers = trailers;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
}
