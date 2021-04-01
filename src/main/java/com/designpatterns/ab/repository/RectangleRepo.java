package com.designpatterns.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.designpatterns.ab.models.Rectangle;
import com.designpatterns.ab.models.Shape;

public interface RectangleRepo  extends JpaRepository<Rectangle, Integer> {

	void save(Shape shape);

}
