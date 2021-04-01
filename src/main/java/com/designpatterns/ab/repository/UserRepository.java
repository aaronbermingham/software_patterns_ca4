package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.User;

public interface UserRepository extends JpaRepository< User, Integer> {

}
