package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
