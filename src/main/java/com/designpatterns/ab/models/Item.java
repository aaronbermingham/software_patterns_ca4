package com.designpatterns.ab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String manufacturer;
	private double price;
	private int stock;
	private String type;
	@ManyToMany
	private List<Review> reviewList;
	
	public Item(String name, String manufacturer, double price, int stock, String type) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.stock = stock;
		this.type = type;
	}

	public Item() {
		super();
	}
	
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	
	
	
	
}
