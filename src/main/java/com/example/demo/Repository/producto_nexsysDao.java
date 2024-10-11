package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.producto_nexsys;

@Repository
public interface producto_nexsysDao extends JpaRepository<producto_nexsys, Long> {

}
