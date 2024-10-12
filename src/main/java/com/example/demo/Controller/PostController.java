package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.Repository.postDao;
import com.example.demo.Service.postDaoService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Api")
public class PostController {

	private final String API_URL = "https://api.escuelajs.co/api/v1/products";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private postDaoService PostDaoService;

	@GetMapping("/postProductos")
	public ResponseEntity<List<postDao>> getPosts() {
		return new ResponseEntity<>(PostDaoService.getPostProducts(), HttpStatus.OK);
	}

	@GetMapping("/post/{id}")
	public ResponseEntity<postDao> get(@PathVariable Integer id) {
		return new ResponseEntity<>(PostDaoService.get(id), HttpStatus.OK);
	}

	public postDao update(Integer id, postDao postDto) {
		HttpEntity<postDao> httpEntity = new HttpEntity<>(postDto);
		ResponseEntity<postDao> response = restTemplate.exchange(API_URL + id, HttpMethod.PUT, httpEntity,
				postDao.class);
		return response.getBody();
	}

	public void delete(Integer id) {
		restTemplate.delete(API_URL + id);
	}
}
