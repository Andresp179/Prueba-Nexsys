package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Producto_nexsysApi;
import com.example.demo.Repository.PostDao;
import com.example.demo.Repository.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ServiceApi serviceApi;
	
	
	public Producto_nexsysApi savePostFromApi(Long id) {
        // Obtener datos de la API
        PostDao postDto = serviceApi.getPostFromApi(id);
        String category=null, images=null;
        // Crear un nuevo objeto de la entidad Post
        Producto_nexsysApi post = new Producto_nexsysApi();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setPrice(postDto.getPrice());
        ObjectMapper maper = new ObjectMapper();
        try {
			 category= maper.writeValueAsString(postDto.getCategory());
			 images = maper.writeValueAsString(postDto.getImages());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        post.setCategory(category);
        post.setImages(images);

        // Guardar la entidad en la base de datos
        return postRepository.save(post);
    }

}
