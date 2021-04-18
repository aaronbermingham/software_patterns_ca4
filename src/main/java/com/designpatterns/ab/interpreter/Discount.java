package com.designpatterns.ab.interpreter;

public interface Discount {
	public boolean studentDiscount(String discount);
	public boolean tenDiscount(String discount);
	public boolean twentyDiscount(String discount);
	
}
