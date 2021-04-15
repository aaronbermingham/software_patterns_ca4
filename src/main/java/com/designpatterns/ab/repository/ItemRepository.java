package com.designpatterns.ab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.designpatterns.ab.models.Item;




public interface ItemRepository extends JpaRepository<Item, Integer>  {
	// SELECT * FROM item WHERE manufacturer LIKE '%apple%' OR name LIKE '%apple%' OR type LIKE '%apple%';
	
	@Query(value = "SELECT * FROM item WHERE manufacturer LIKE %?1% OR name LIKE %?1% OR type LIKE %?1%", nativeQuery = true)
	List<Item> searchItem(@Param("item")String item);
}
