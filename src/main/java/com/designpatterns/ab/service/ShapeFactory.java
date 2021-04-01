package com.designpatterns.ab.service;

import com.designpatterns.ab.models.Circle;
import com.designpatterns.ab.models.Rectangle;
import com.designpatterns.ab.models.Shape;

public class ShapeFactory {
	public Shape getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("CIRCLE")){
	         return new Circle("I'm a circle", 5);
	         
	      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle("I'm a rectangle");
	         
	      } 
	      
	      return null;
	   }
}
