package com.designpatterns.ab.strategy;

import java.util.List;

import com.designpatterns.ab.models.Item;

public class Context {
	private SortStrategy sortStrategy;
	
	public Context(SortStrategy sortStrategy){
	      this.sortStrategy = sortStrategy;
	   }

	   public List<Item> executeSortStrategy(List<Item> itemList){
	      return sortStrategy.sort(itemList);
	   }
}
