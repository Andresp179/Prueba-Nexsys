package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Models.Producto_nexsys;
import com.example.demo.Repository.PostDao;



public interface Producto_nexsysService {
    
	
	public List<Producto_nexsys> listaProductos();

    public Producto_nexsys guardar (Producto_nexsys producto);

    public void eliminar (Producto_nexsys producto);

    public Optional<Producto_nexsys> encontrarProducto(Producto_nexsys producto);	
    
    public int[] batchUpdateUsingJdbcTemplate(List<Producto_nexsys> productos);    
}
