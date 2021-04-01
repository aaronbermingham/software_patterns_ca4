package com.designpatterns.ab.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Circle implements Shape {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String circleString;
	private int radius;
	
	

	   public Circle(String circleString, int radius) {
		super();
		this.circleString = circleString;
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String getCircleString() {
		return circleString;
	}

	public void setCircleString(String circleString) {
		this.circleString = circleString;
	}
	
	

	@Override
	public String toString() {
		return "Circle [circleString=" + circleString + ", radius=" + radius + "]";
	}

	@Override
	   public void draw() {
	      System.out.println("Inside Circle::draw() method.");
	   }
	   
	   
	}
