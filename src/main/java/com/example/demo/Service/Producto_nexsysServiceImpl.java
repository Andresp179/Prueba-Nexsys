package com.example.demo.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.Models.Producto_nexsys;
import com.example.demo.Repository.Producto_nexsysDao;


public class Producto_nexsysServiceImpl implements Producto_nexsysService {

	private Producto_nexsysDao productoServiceDao;
	private  JdbcTemplate jdbcTemplate;
	@Override
	public List<Producto_nexsys> listaProductos() {
		return (List<Producto_nexsys>) productoServiceDao.findAll();
	}

	@Override
	public Producto_nexsys guardar(Producto_nexsys producto) {		
		return productoServiceDao.save(producto);
	}

	@Override
	public void eliminar(Producto_nexsys producto) {
		 productoServiceDao.delete(producto);		
	}

	@Override
	public Optional<Producto_nexsys> encontrarProducto(Producto_nexsys producto) {
		// TODO Auto-generated method stub
		return productoServiceDao.findById(producto.getIdProducto());
	}

	@Override
	public int[] batchUpdateUsingJdbcTemplate(List<Producto_nexsys> productos) {
		return jdbcTemplate.batchUpdate("INSERT INTO producto_nexsys VALUES (?, ?, ?, ?,?)", (BatchPreparedStatementSetter) new BatchPreparedStatementSetter() {

            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
                ps.setLong(1, productos.get(i).getIdProducto());
                ps.setString(2, productos.get(i).getName());
                ps.setString(3, productos.get(i).getDescription());
                ps.setString(4, productos.get(i).getImageUrl());
        }

            @Override
            public int getBatchSize() {
                return 3;
            }				
        });
	}

}
