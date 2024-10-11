package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Excepciones.ResourceNotFoundException;
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
	
	// este metodo sirve para buscar un producto
	@GetMapping("/api/v1/productos/{id}")
	public ResponseEntity<producto_nexsys> obtenerProductoPorId(@PathVariable Long id) {
		producto_nexsys producto = productoServiceImpl.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
		return ResponseEntity.ok(producto);
	}
	
	//este metodo sirve para actualizar producto
	@PutMapping("/api/v1/productos/{id}")
	public ResponseEntity<producto_nexsys> actualizarProducto(@PathVariable Long id,@RequestBody producto_nexsys detallesProducto){
		producto_nexsys producto = productoServiceImpl.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
		
		producto.setName(detallesProducto.getName());
		producto.setPriceFinal(detallesProducto.getPriceFinal());
		producto.setCategoryId(detallesProducto.getCategoryId());
		producto.setImageUrl(detallesProducto.getImageUrl());
		
		producto_nexsys productoActualizado = productoServiceImpl.save(producto);
		return ResponseEntity.ok(productoActualizado);
    }
	
	@DeleteMapping("/api/v1//productos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable Long id){
		producto_nexsys producto = productoServiceImpl.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
		
		productoServiceImpl.delete(producto);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}
