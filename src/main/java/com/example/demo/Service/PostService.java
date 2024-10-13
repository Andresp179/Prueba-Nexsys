package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Producto_nexsysApi;
import com.example.demo.Repository.PostDao;
import com.example.demo.Repository.PostRepository;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ServiceApi serviceApi;
	
	
	public Producto_nexsysApi savePostFromApi(Long id) {
        // Obtener datos de la API
        PostDao postDto = serviceApi.getPostFromApi(id);

        // Crear un nuevo objeto de la entidad Post
        Producto_nexsysApi post = new Producto_nexsysApi();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setPrice(postDto.getPrice());
        post.setCategory(postDto.getCategory());
        post.setImages(postDto.getImages());

        // Guardar la entidad en la base de datos
        return postRepository.save(post);
    }

}
