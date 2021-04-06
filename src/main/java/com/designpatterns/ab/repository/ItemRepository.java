package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.Item;



public interface ItemRepository extends JpaRepository<Item, Integer>  {

}
