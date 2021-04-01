package com.designpatterns.ab.models;

public class AdminUserDecorator extends UserDecorator {

	public AdminUserDecorator(User decoratedUser) {
		super(decoratedUser);
		
	}

}
