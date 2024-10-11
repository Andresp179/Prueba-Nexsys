package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Models.producto_nexsys;
import com.example.demo.Repository.producto_nexsysDao;
import com.example.demo.Service.producto_nexsysServiceImpl;

@RestController
@RequestMapping
public class producto_nexsysController {

	
	@Autowired
	private producto_nexsysDao productoServiceImpl;
	
	@RequestMapping(value = "/api/v1/productos", method = RequestMethod.GET)
	public List<producto_nexsys> listarProductos() {
		return productoServiceImpl.findAll();
	}
}
