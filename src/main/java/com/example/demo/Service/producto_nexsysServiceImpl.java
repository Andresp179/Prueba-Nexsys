package com.example.demo.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.Models.producto_nexsys;
import com.example.demo.Repository.producto_nexsysDao;


public class producto_nexsysServiceImpl implements producto_nexsysService {

	private producto_nexsysDao productoServiceDao;
	private  JdbcTemplate jdbcTemplate;
	@Override
	public List<producto_nexsys> listaProductos() {
		return (List<producto_nexsys>) productoServiceDao.findAll();
	}

	@Override
	public void guardar(producto_nexsys producto) {		
		productoServiceDao.save(producto);
	}

	@Override
	public void eliminar(producto_nexsys producto) {
		productoServiceDao.delete(producto);		
	}

	@Override
	public Optional<producto_nexsys> encontrarProducto(producto_nexsys producto) {
		// TODO Auto-generated method stub
		return productoServiceDao.findById(producto.getIdProducto());
	}

	@Override
	public int[] batchUpdateUsingJdbcTemplate(List<producto_nexsys> productos) {
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
