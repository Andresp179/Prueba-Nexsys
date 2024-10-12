package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Producto_nexsys;

@Repository
public interface Producto_nexsysDao extends JpaRepository<Producto_nexsys, Long> {

}
