package com.designpatterns.ab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.designpatterns.ab.models.User;
@Repository
public interface UserRepository extends JpaRepository< User, Integer> {
	Optional<User> findByName(String name);

	Boolean existsByName(String name);

	Boolean existsByEmail(String email);
}
