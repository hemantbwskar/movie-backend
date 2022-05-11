package com.hrb.moviedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.hrb.moviedb.models.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {
	
	@Query("SELECT u FROM my_user u WHERE u.username = 'admin'")
	public MyUser findByUsername(@Param("username") String username);

	public MyUser getByUsername(String userName);
	
	public MyUser getByEmailId(String emailId);
	

}
