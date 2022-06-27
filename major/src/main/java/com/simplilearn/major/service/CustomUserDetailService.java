package com.simplilearn.major.service;

import java.util.Optional;

import com.simplilearn.major.model.CustomUserDetail;
import com.simplilearn.major.model.User;
import com.simplilearn.major.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException{
		
		Optional<User> user = userRepository.findUserByEmail(email);
		
		user.orElseThrow(()-> new UsernameNotFoundException("user not found"));
		return user.map(CustomUserDetail::new).get();
		
	}

}
