package com.example.demo.Security;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserSecurity {

	  @Bean
	    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	        UserDetails user = User.withUsername("user")
	                .password(passwordEncoder.encode("password1234//"))
	                .roles("USER")
	                .build();
	        UserDetails admin = User.withUsername("prueba")
	                .password(passwordEncoder.encode("admin**//"))
	                .roles("ADMIN")
	                .build();
	        
	        return new InMemoryUserDetailsManager(user, admin);
	    }
}
