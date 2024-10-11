package com.example.demo.Repository;

public class postDao {
	
	private Integer id;
	private String title;
	private Integer price;
	private String category;
	private String images;
	public postDao() {
		super();
	}
	@Override
	public String toString() {
		return "postDao [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category + ", images="
				+ images + "]";
		
	}
	public postDao(Integer id, String title, Integer price, String category, String images) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.category = category;
		this.images = images;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}

}
