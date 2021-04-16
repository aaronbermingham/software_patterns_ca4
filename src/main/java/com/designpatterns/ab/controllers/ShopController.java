package com.designpatterns.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.ab.models.Item;
import com.designpatterns.ab.models.Shop;
import com.designpatterns.ab.repository.ShopRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/shop")
public class ShopController {
	@Autowired
	ShopRepository shopRepository;
	
	@PostMapping("/addShop")
	public Shop addShop(@RequestBody Shop s) {
		Shop shop = Shop.getInstance();
		shop.setName(s.getName());
		shop.setAddress(s.getAddress());
		shop.setEmail(s.getEmail());
		shop.setPhoneNumber(s.getPhoneNumber());
		return shopRepository.save(shop);
	}
	
//	@PutMapping("/addShopDetails")
//	public Shop addShopDetails() {
//		Shop shop = shopRepository.findById(1).get();
//		shop.s
//		return shopRepository.save(shop);
//	}
	

}
