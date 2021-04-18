package com.designpatterns.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.ab.models.Address;
import com.designpatterns.ab.models.User;
import com.designpatterns.ab.repository.AddressRepository;
import com.designpatterns.ab.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/address")
public class AddressController {
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UserRepository userRepository;

	// create user
	@PostMapping("/addAddress/{id}")
	public Address addUserAddress(@PathVariable int id, @RequestBody Address a) {
		User u = userRepository.findById(id).get();
		u.setAddress(a);
		return addressRepository.save(a);
	}
}
