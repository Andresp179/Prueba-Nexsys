package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import com.example.demo.Repository.postDao;

@Service
public class postDaoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<postDao> getCategoriasFromExternalApi() {
	    ResponseEntity<List<postDao>> response = restTemplate.exchange(
	        "https://api.externa.com/categorias",
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<postDao>>() {}

	        );
	    return response.getBody();
	}

}
