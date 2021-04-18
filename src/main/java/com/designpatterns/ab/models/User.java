package com.designpatterns.ab.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.ComponentScan;


import javax.persistence.JoinColumn;

@Entity
public class User  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String email;
	private String password;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true, mappedBy="user")
	private List<ShoppingCart> cart;
	@OneToOne(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true, mappedBy="user")
	Paypal paypalPayment;
	@OneToOne(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true, mappedBy="user")
	CreditCard cardPayment;
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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
	
	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ShoppingCart> getCart() {
		return cart;
	}

	public void setCart(List<ShoppingCart> cart) {
		this.cart = cart;
	}

	public Set<Role> getRole() {
		return roles;
	}

	public void setRole(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Paypal getPaypalPayment() {
		return paypalPayment;
	}

	public void setPaypalPayment(Paypal paypalPayment) {
		this.paypalPayment = paypalPayment;
	}

	public CreditCard getCardPayment() {
		return cardPayment;
	}

	public void setCardPayment(CreditCard cardPayment) {
		this.cardPayment = cardPayment;
	}
	
	

}
