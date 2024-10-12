package com.example.demo.Repository;

import java.util.List;

public class PostDao {

	private Integer id;
	private String title;
	private Integer price;
	private String description;
	private Object category;
	private List<String> images;

	public PostDao() {
		super();
	}

	@Override
	public String toString() {
		return "postDao [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category + ", images="
				+ images + "]";

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

	public Object getCategory() {
		return category;
	}

	public void setCategory(Object category) {
		this.category = category;
	}

	public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

	public PostDao(Integer id, String title, Integer price, String description, Object category, List<String> images) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
