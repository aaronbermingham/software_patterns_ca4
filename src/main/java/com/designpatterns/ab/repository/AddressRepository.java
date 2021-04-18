package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
