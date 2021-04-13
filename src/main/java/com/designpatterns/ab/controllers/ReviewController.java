package com.designpatterns.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.ab.models.Item;
import com.designpatterns.ab.models.Review;
import com.designpatterns.ab.repository.ItemRepository;
import com.designpatterns.ab.repository.ReviewRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/review")
public class ReviewController {
	
	@Autowired
	private ItemRepository itemRepo;
	
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	
	@PostMapping("/addReview/{itemId}")
	public Review addUser(@RequestBody Review r, @PathVariable int itemId) {
		Item i = itemRepo.findById(itemId).get();
		i.getReviewList().add(r);
		return reviewRepo.save(r);
	}
	
	@GetMapping("/all")
	public List<Review> getAllReviews(){
		return reviewRepo.findAll();
	}
	
	@GetMapping("/reviewByProductId/{itemId}")
	public List<Review> getAllReviewsByProductId(@PathVariable int itemId){
		return reviewRepo.getReviewByItemId(itemId);
	}
	
}
