package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Producto_nexsysApi;

@Repository
public interface PostRepository extends JpaRepository<Producto_nexsysApi, Long>{

}
