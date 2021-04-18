package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.Payment;
import com.designpatterns.ab.models.Paypal;

public interface PayPalRepository extends JpaRepository<Paypal, Integer> {
	void save(Payment payment);
}
