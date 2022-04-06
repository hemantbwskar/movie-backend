package com.hrb.moviedb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hrb.moviedb.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>, JpaSpecificationExecutor<Movie> {
	
	@Query("SELECT m FROM Movie m WHERE CONCAT(m.title) LIKE %?1% ORDER BY m.title ASC")
	public List<Movie> findByTitleOrderByTitleAsc(String title);
	
	@Query("SELECT m FROM Movie m WHERE CONCAT(m.title) LIKE %?1% ORDER BY m.released ASC")
	public List<Movie> findByTitleOrderByReleasedAsc(String title);
//	
////	@Query("SELECT m FROM Movie m WHERE CONCAT(m.title) LIKE %?1% ORDER BY m.added ASC")
////	public List<Movie> findByTitleOrderByAddedAsc(String title);
////	
////	@Query("SELECT m FROM Movie m WHERE CONCAT(m.title) LIKE %?1% ORDER BY m.created ASC")
////	public List<Movie> findByTitleOrderByCreatedAsc(String title);
////	
////	@Query("SELECT m FROM Movie m WHERE CONCAT(m.title) LIKE %?1% ORDER BY m.updated ASC")
////	public List<Movie> findByTitleOrderByUpdatedAsc(String title);
//	
	@Query("SELECT m FROM Movie m WHERE CONCAT(m.title) LIKE %?1% ORDER BY m.ratings ASC")
	public List<Movie> findByTitleOrderByRatingsAsc(String title);
//	
	@Query("SELECT m FROM Movie m WHERE CONCAT(m.title) LIKE %?1% ORDER BY m.metacritic ASC")
	public List<Movie> findByTitleOrderByMetacriticAsc(String title);


	
}
