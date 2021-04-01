package com.designpatterns.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.ab.models.Circle;
import com.designpatterns.ab.models.Rectangle;
import com.designpatterns.ab.models.Shape;
import com.designpatterns.ab.repository.CircleRepo;
import com.designpatterns.ab.repository.RectangleRepo;
import com.designpatterns.ab.service.ShapeFactory;

@RestController
@RequestMapping("api/shape/")
public class ShapeController {
	@Autowired
	CircleRepo cRepo;
	@Autowired
	RectangleRepo rRepo;
	
	private ShapeFactory shapeFactory = new ShapeFactory() ;
	@RequestMapping("/tester")
	public @ResponseBody String greeting() {
		return "Hello, World";
	}
	
	@RequestMapping("/shape/{s}")
	public @ResponseBody String shape(@PathVariable String s ) {
		Shape shape = shapeFactory.getShape(s);
		if (s.equals("CIRCLE")) {
			cRepo.save(shape);
		}
		else if(s.equals("RECTANGLE")) {
			rRepo.save(shape);		}
	      
	      return shape.toString();
	}
	

	@GetMapping("/addShape/{type}")
	public String getShape(@PathVariable String type ) {
		 if(type == null){
	         return null;
	      }		
	      if(type.equalsIgnoreCase("CIRCLE")){
	    	  Shape circle = new Circle("I'm a circle",5);
	         return circle.toString();
	         
	      } else if(type.equalsIgnoreCase("RECTANGLE")){
	    	  Shape shape = new Rectangle("I'm a rectangle");
	         return shape.toString();
	         
	      } 
	      
	      return null;
	   }
	

@GetMapping("/test")
public String getAllItems(){
	return "this is a test";
}
}

