package com.example.demo.Models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column
	private Long idProducto;
	
	@Column
	private String name;
	
	@Column
	private int priceFinal;
	
	@Column
	private String description;
	
	@Column
	private int categoryId;
	
	@Column
	private String imageUrl;

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", name=" + name + ", priceFinal=" + priceFinal + ", description="
				+ description + ", categoryId=" + categoryId + ", imageUrl=" + imageUrl + "]";
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public Producto(Long idProducto, String name, int priceFinal, String description, int categoryId, String imageUrl) {
		super();
		this.idProducto = idProducto;
		this.name = name;
		this.priceFinal = priceFinal;
		this.description = description;
		this.categoryId = categoryId;
		this.imageUrl = imageUrl;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriceFinal() {
		return priceFinal;
	}

	public void setPriceFinal(int priceFinal) {
		this.priceFinal = priceFinal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
