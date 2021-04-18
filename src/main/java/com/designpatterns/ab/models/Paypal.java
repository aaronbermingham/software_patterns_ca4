package com.designpatterns.ab.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.ComponentScan;

import com.designpatterns.ab.models.User;

@Entity
public class Paypal implements Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String email;
	String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	public Paypal() {
		super();
	}



	public Paypal(String email, String password, User user) {
		super();
		this.email = email;
		this.password = password;
		this.user = user;
	}
	
	


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getId() {
		return id;
	}



	@Override
	public String payment() {
		
		return "paypal";
	}

}
