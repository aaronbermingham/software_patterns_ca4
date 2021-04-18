package com.designpatterns.ab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.designpatterns.ab.models.Review;
import com.designpatterns.ab.models.ShoppingCart;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	@Query(value = "SELECT  DISTINCT  id, review_stars, review_text FROM review INNER JOIN item_review_list itr ON itr.item_id = ?1", nativeQuery = true)
	List<Review> getReviewByItemId(int id);
}
