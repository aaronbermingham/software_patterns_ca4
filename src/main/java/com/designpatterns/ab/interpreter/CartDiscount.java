package com.designpatterns.ab.interpreter;

public class CartDiscount implements Discount {

	@Override
	public boolean studentDiscount(String discount) {
		
		if(discount.equals("stu_discount")) {
			
			return true;
		}
		return false;
	}

	@Override
	public boolean tenDiscount(String discount) {
		if(discount.equals("tendisc")) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean twentyDiscount(String discount) {
		if(discount.equals("twentydisc")) {	return true;
	}
	return false;
	}

}
