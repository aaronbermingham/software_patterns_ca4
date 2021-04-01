package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.Items;



public interface ItemRepository extends JpaRepository<Items, Integer>  {

}
