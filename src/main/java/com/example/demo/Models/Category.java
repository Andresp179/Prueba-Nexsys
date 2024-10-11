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
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column
	private long idCategoria;
	
	@Column
	private int cid;
	
	@Column
	private String title;

	@Override
	public String toString() {
		return "Category [idCategoria=" + idCategoria + ", cid=" + cid + ", title=" + title + "]";
	}

	public Category(long idCategoria, int cid, String title) {
		super();
		this.idCategoria = idCategoria;
		this.cid = cid;
		this.title = title;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}
