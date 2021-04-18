package com.designpatterns.ab.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.ab.interpreter.CartDiscount;
import com.designpatterns.ab.models.Item;
import com.designpatterns.ab.models.ShoppingCart;
import com.designpatterns.ab.models.User;
import com.designpatterns.ab.repository.ItemRepository;
import com.designpatterns.ab.repository.ShoppingCartRepository;
import com.designpatterns.ab.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth/cart")
public class ShoppingCartController {
	@Autowired
	private ShoppingCartRepository cartRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<ShoppingCart> getAllBookings() {
		return cartRepository.findAll();
	}
	
	@PostMapping("/addItem/{itemId}/{userId}")
	public ShoppingCart addItem(@PathVariable int itemId, @PathVariable int userId ) {
		ShoppingCart cart = new ShoppingCart();
		cartRepository.save(cart);
		double total = 0;
		User user = userRepository.findById(userId).get();
		//ShoppingCart cart = cartRepository.findById(cartId).get();
		Item item = itemRepository.findById(itemId).get();
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(item);
		cart.setItemList(itemList);
		cart.setUser(user);
		item.setStock(item.getStock() -1);
		
		for (Item i : cart.getItemList()) {
			total += i.getPrice();
		}
		cart.setTotalPrice(total);
		return cartRepository.save(cart);
	}
	
	@GetMapping("/cartById/{id}")
	public ResponseEntity<ShoppingCart> getCartByID(@PathVariable int id) {
		ShoppingCart cart = cartRepository.findById(id).get();
				//.orElseThrow(() -> new ResourceNotFoundException("Cart with ID:" + id + " does not exist"));
		return ResponseEntity.ok(cart);
	}
	
	@GetMapping("/cartByUserId/{id}")
	public List<ShoppingCart> getCartByUserID(@PathVariable int id) {
		return cartRepository.getCartByUserId(id);
		
	}
	
	@GetMapping("/cartDiscount/{id}/{discountString}")
	public double getCartDiscount(@PathVariable int id, @PathVariable String discountString) {
		ShoppingCart cart = cartRepository.findById(id).get();
		double discountedPrice = 0;
		CartDiscount discount = new CartDiscount();
		if(discount.studentDiscount(discountString) == true) {
			discountedPrice = cart.getTotalPrice() -(cart.getTotalPrice()*.15);
			cart.setTotalPrice(discountedPrice);
			cartRepository.save(cart);
			return discountedPrice;
		}
		else if(discount.tenDiscount(discountString) == true) {
			discountedPrice = cart.getTotalPrice() -(cart.getTotalPrice()*.10);
			cart.setTotalPrice(discountedPrice);
			cartRepository.save(cart);
			return discountedPrice;
		}
		else if(discount.twentyDiscount(discountString) == true) {
			discountedPrice = cart.getTotalPrice() -(cart.getTotalPrice()*.20);
			cart.setTotalPrice(discountedPrice);
			cartRepository.save(cart);
			return discountedPrice;
		}
		return discountedPrice;
	}
	
	
	// Delete a cart
	@DeleteMapping("/deleteCart/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCart(@PathVariable int id) {
		ShoppingCart cart = cartRepository.findById(id).get();
		
		//tR.setReserved(false);
		cartRepository.delete(cart);
		Map<String, Boolean> cartDeleted = new HashMap<String, Boolean>();
		cartDeleted.put("Booking deleted", Boolean.TRUE);

		return ResponseEntity.ok(cartDeleted);
	}
	
	

}
