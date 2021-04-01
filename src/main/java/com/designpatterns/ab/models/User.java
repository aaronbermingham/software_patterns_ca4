package com.designpatterns.ab.models;

public class User implements UserInterface {
	private int id;
	private String name;
	private String address;
	private String email;
	
	public User(String name, String address, String email) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public User() {

	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
