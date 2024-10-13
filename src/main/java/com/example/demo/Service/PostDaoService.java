package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import com.example.demo.Repository.PostDao;
import java.util.Arrays;
import org.springframework.http.HttpEntity;


@Service
public class PostDaoService {

	@Autowired
	private RestTemplate restTemplate;

	private final String API_URL = "https://api.escuelajs.co/api/v1/";

	public List<PostDao> getProductosFromExternalApi() {
		ResponseEntity<List<PostDao>> response = restTemplate.exchange(API_URL + "products",
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<PostDao>>() {}
		        );
		return response.getBody();

	}

	public PostDao get(Integer id) {
		return restTemplate.getForEntity(API_URL+"products/" + id, PostDao.class).getBody();
	}

	public PostDao save(PostDao postDao) {
		return restTemplate.postForObject(API_URL + "products/", postDao, PostDao.class);
	}

	public PostDao update(Integer id, PostDao postDao) {
		HttpEntity<PostDao> httpEntity = new HttpEntity<>(postDao);
		ResponseEntity<PostDao> response = restTemplate.exchange(API_URL + "products/" + id, HttpMethod.PUT, httpEntity,
				PostDao.class);
		// restTemplate.put("https://jsonplaceholder.typicode.com/posts/"+id, postDto);
		return response.getBody();
	}
	
	   public void delete(Integer id){
	        restTemplate.delete(API_URL+"products"+id);
	    }

	public List<PostDao> getPostProducts() {
		ResponseEntity<List<PostDao>> response = restTemplate.exchange(API_URL + "products/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PostDao>>() {
				});
		return response.getBody();
	}
}