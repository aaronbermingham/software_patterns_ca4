package com.designpatterns.ab.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String address1;
	public String address2;
	public String town;
	public String county;
	public String country;
	 @OneToOne(mappedBy = "address")
	public User user;
	
	public Address(String address1, String address2, String town, String county, String country) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.town = town;
		this.county = county;
		this.country = country;
	}

	public Address() {
		super();
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}
	
	
	
	

}
