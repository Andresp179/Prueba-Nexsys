package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Repository.PostDao;

@Service
public class ServiceApi {

	@Autowired
	private RestTemplate restTemplate;
	
	  public PostDao getPostFromApi(Long id) {
	        return restTemplate.getForObject("https://api.escuelajs.co/api/v1/products/" + id, 
	        	   PostDao.class);
	    }

}
