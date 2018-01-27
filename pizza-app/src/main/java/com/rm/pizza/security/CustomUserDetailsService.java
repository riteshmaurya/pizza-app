package com.rm.pizza.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rm.pizza.domain.repositories.AutoUserRepository;

@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AutoUserRepository autoUserRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return autoUserRepository.findByUsername(username);
	}

}
