package com.designpatterns.ab.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.ab.models.Role;
import com.designpatterns.ab.models.ShoppingCart;
import com.designpatterns.ab.models.User;
import com.designpatterns.ab.repository.ShoppingCartRepository;
import com.designpatterns.ab.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShoppingCartRepository cartRepository;
	

	@PostMapping("/addCart/{id}")
	public ShoppingCart addCartUser(@PathVariable int id, @RequestBody ShoppingCart cart) {
		List<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
		
		User user = userRepository.findById(id).get();
		if(user.getCart().isEmpty()) {
			cartList.add(cart);
			user.setCart(cartList);
		}
		else {
			user.getCart().add(cart);
		}
	
		return cart;
	}
	
	@GetMapping("/users")
 	public List<User> getAllUsers() {
 		return userRepository.findAll();
 	}
	
	@PostMapping("/signUpAdmin")
	public ResponseEntity<?> registerAdmin(@RequestBody User adminUser) {
		// Create new user's account
		User newAdminUser = new User(adminUser.getName(), adminUser.getAddress(), adminUser.getEmail(), adminUser.getRole(), adminUser.getPassword() );
		userRepository.save(newAdminUser);
		return ResponseEntity.ok(newAdminUser);
	}
	
	@PostMapping("/signUpUser")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		// Create new user's account
		User newUser = new User(user.getName(), user.getAddress(), user.getEmail(), user.getRole(), user.getPassword() );
		userRepository.save(newUser);
		return ResponseEntity.ok(newUser);
	}
	
}
