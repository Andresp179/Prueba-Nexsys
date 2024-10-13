package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ConfigSecurityFilterChain  {
	

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Si deseas deshabilitar CSRF (usualmente para APIs)
            .authorizeHttpRequests() 
            .requestMatchers("/admin/**").hasRole("admin") //Permitir acceso por admin
            .requestMatchers("/user/**").hasRole("user")// Permitir acceso apor usuario
            .anyRequest().authenticated() // Proteger todas las demás rutas
            .and()
            .httpBasic(); // Puedes cambiar a formLogin si prefieres un login basado en formularios

        return http.build();
    }
	 
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

  
}
