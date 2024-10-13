package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NexsysPruebaAndresPerezApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexsysPruebaAndresPerezApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {		
		return new RestTemplate(); //Para poder consumir la otra API
	}
	
	
}
