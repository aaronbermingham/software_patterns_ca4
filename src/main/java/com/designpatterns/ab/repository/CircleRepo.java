package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.Circle;
import com.designpatterns.ab.models.Shape;

public interface CircleRepo  extends JpaRepository<Circle, Integer> {

	void save(Shape shape);

}
