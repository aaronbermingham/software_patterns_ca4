package com.designpatterns.ab.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CreditCard implements Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String ccv;
	private String endDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	

	public CreditCard(String name, String ccv, String endDate) {
		super();
		this.name = name;
		this.ccv = ccv;
		this.endDate = endDate;
	}

	

	public CreditCard() {
		super();
	}
	
	



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCcv() {
		return ccv;
	}



	public void setCcv(String ccv) {
		this.ccv = ccv;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public int getId() {
		return id;
	}



	@Override
	public String payment() {
		
		return "credit";
	}

}
