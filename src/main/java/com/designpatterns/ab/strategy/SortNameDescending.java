package com.designpatterns.ab.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.designpatterns.ab.models.Item;

public class SortNameDescending implements SortStrategy{

	@Override
	public List<Item> sort(List<Item> itemList) {
		List<Item> sortedItems = itemList.stream()
				  .sorted(Comparator.comparing(Item::getName).reversed())
				  .collect(Collectors.toList());
		return sortedItems;
	}

}
