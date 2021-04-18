package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.CreditCard;
import com.designpatterns.ab.models.Payment;


public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
	void save(Payment payment);
}
