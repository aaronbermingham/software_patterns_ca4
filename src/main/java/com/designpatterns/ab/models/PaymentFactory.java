package com.designpatterns.ab.models;

public class PaymentFactory {
	public Payment getPaymentType(String type) {
		if(type == null){
	         return null;
	      }		
	      if(type.equalsIgnoreCase("paypal")){
	         return new Paypal();
	         
	      } else if(type.equalsIgnoreCase("credit")){
	         return new CreditCard();
	         
	      }
	      return null;
		
	}
}
