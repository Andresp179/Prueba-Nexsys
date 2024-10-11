package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import com.example.demo.Repository.postDao;
import com.example.demo.Repository.producto_nexsysDao;
import java.util.Arrays;
import java.util.List;

@Service
public class postDaoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	producto_nexsysDao productoDao;
	
	private final String API_URL = "https://api.escuelajs.co/api/v1/products/";
	
	public List<postDao> getCategoriasFromExternalApi() {
	    ResponseEntity<List<postDao>> response = restTemplate.exchange(
	        API_URL,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<List<postDao>>() {}

	        );
	    return response.getBody();
	}
	
	public postDao get(Integer id) {
	  return restTemplate.getForEntity(API_URL+id,postDao.class)
			             .getBody();
	}
	
	public postDao save(postDao PostDao) {		
	
		
		
		return null;

}
}