package com.designpatterns.ab.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rectangle implements Shape {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rec;
	
	
	public Rectangle(String rec) {
		super();
		this.rec = rec;
	}


	public String getRec() {
		return rec;
	}


	public void setRec(String rec) {
		this.rec = rec;
	}
	
	


	@Override
	public String toString() {
		return "Rectangle [rec=" + rec + "]";
	}


	@Override
	public void draw() {
		 System.out.println("Inside Rectangle::draw() method.");
	}

}
