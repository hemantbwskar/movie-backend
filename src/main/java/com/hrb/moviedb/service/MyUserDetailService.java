package com.hrb.moviedb.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrb.moviedb.models.MyUser;
import com.hrb.moviedb.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public void addAdministartor() {
		MyUser admin=new MyUser();
		admin.setUserId(1);
		admin.setUsername("admin");
		admin.setPassword("admin");
		
		userRepository.save(admin);
	}
	public void addHemant() {
		MyUser hemant=new MyUser();
		hemant.setUserId(2);
		hemant.setUsername("hemant");
		hemant.setPassword("hemant");
		
		userRepository.save(hemant);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		MyUser currentUser=userRepository.getByUsername(userName);
//		System.out.println(currentUser.toString());
		return new User(currentUser.getUsername(),currentUser.getPassword(),new ArrayList<>());
	}
	
	

}
