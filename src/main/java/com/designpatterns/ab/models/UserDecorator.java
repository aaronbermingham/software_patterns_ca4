package com.designpatterns.ab.models;

public abstract class UserDecorator implements UserInterface {
	 protected User decoratedUser;
	 
	 public UserDecorator(User decoratedUser) {
		 this.decoratedUser = decoratedUser;
	 }
	
	@Override
	public String getName() {
		return this.decoratedUser.getName();
	}

	@Override
	public void setName(String name) {
		this.decoratedUser.setName(name);

	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return this.decoratedUser.getAddress();
	}

	@Override
	public void setAddress(String address) {
		this.decoratedUser.setAddress(address);

	}

	@Override
	public String getEmail() {
		return this.decoratedUser.getEmail();
	}

	@Override
	public void setEmail(String email) {
		this.decoratedUser.setEmail(email);
	}

}
