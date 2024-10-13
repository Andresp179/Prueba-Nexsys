package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Models.Producto_nexsysApi;
import com.example.demo.Repository.PostDao;
import com.example.demo.Service.PostDaoService;
import com.example.demo.Service.PostService;
import com.example.demo.Service.ServiceApi;

import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class PostController {

	private final String API_URL = "https://api.escuelajs.co/api/v1/products";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PostDaoService postDaoService;

	@Autowired
	private ServiceApi serviceApi;
	
    @Autowired
    private PostService postServise;
	
	@GetMapping("/nexsys/v1/product/")
	public ResponseEntity<List<PostDao>> getPosts() {
		return new ResponseEntity<>(postDaoService.getPostProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/nexsys/v1/product/savePost/{id}")
    public Producto_nexsysApi savePost(@PathVariable Long id) {
        return postServise.savePostFromApi(id);
    }
	
	@PostMapping("/sync")
	public ResponseEntity<PostDao> syncProductFromApi(PostDao postDao) {
		// Llamar al servicio para obtener el producto de la API y guardarlo
		PostDao product = postDaoService.save(postDao);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	@GetMapping("/nexsys/v1/product/{id}")
	public ResponseEntity<PostDao> get(@PathVariable Integer id) {
		return new ResponseEntity<>(postDaoService.get(id), HttpStatus.OK);
	}

	public PostDao update(Integer id, PostDao postDto) {
		HttpEntity<PostDao> httpEntity = new HttpEntity<>(postDto);
		ResponseEntity<PostDao> response = restTemplate.exchange(API_URL + id, HttpMethod.PUT, httpEntity,
				PostDao.class);
		return response.getBody();
	}

	public void delete(Integer id) {
		restTemplate.delete(API_URL + id);
	}
}
