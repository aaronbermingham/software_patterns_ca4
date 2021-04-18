package com.designpatterns.ab.strategy;

import java.util.List;

import com.designpatterns.ab.models.Item;

public interface SortStrategy {
	public List<Item> sort(List<Item> itemList);
}
