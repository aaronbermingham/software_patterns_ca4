package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
