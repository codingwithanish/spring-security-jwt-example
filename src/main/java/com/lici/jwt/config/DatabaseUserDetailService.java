package com.lici.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lici.jwt.entity.User;
import com.lici.jwt.repo.UserRepository;

@Service
public class DatabaseUserDetailService implements UserDetailsService{

	@Autowired 
	   private UserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepository.findUserByUsername(username)
		         .orElseThrow(() -> new UsernameNotFoundException("User not present"));
		 user.setPassword(passwordEncoder().encode(user.getPassword()));
		return user; 
	}
	
	 @Bean
		public BCryptPasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}
	
	
}
