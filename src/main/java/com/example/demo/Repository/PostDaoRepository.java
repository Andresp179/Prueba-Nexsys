package com.example.demo.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Models.Producto_nexsys;
import com.example.demo.Service.PostDaoService;
import com.example.demo.Service.Producto_nexsysService;
import com.example.demo.Service.Producto_nexsysServiceImpl;

public class PostDaoRepository {
	
	@Autowired
	private Producto_nexsys producto_nexsys;
	
	@Autowired
	private PostDaoService postDaoService;
	
	@Autowired
	private PostDao postDao;
	
	public Producto_nexsys saveProductFromApi() {
		
		Producto_nexsysDao productDao= (Producto_nexsysDao) postDaoService.getProductosFromExternalApi();
		
		Producto_nexsys Producto = new Producto_nexsys();
		
		Producto_nexsysService productService = null;
		
		Producto.setName(postDao.getTitle());
		Producto.setPriceFinal(postDao.getPrice());
		Producto.setDescription(postDao.getDescription());
		Producto.setCategoryId(postDao.getId());
		//Producto.setImageUrl(postDao.getImages());
		
		
		return productService.guardar(Producto);
	}

}
