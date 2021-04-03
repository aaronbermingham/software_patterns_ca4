package com.designpatterns.ab.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reviewText;
	private int reviewStars;
	
	public Review(String reviewText, int reviewStars) {
		super();
		this.reviewText = reviewText;
		this.reviewStars = reviewStars;
	}

	public Review() {
		super();
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getReviewStars() {
		return reviewStars;
	}

	public void setReviewStars(int reviewStars) {
		this.reviewStars = reviewStars;
	}
	
	
	
	

}
