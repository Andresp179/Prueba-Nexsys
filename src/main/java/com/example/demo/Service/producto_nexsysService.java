package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Models.producto_nexsys;



public interface producto_nexsysService {

	
	public List<producto_nexsys> listaProductos();

    public void guardar (producto_nexsys producto);

    public void eliminar (producto_nexsys producto);

    public Optional<producto_nexsys> encontrarProducto(producto_nexsys producto);	
    
    public int[] batchUpdateUsingJdbcTemplate(List<producto_nexsys> productos);    
}
