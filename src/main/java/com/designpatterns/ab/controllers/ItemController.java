package com.designpatterns.ab.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.designpatterns.ab.models.Item;
import com.designpatterns.ab.repository.ItemRepository;
import com.designpatterns.ab.strategy.Context;
import com.designpatterns.ab.strategy.SortCategoreyAscending;
import com.designpatterns.ab.strategy.SortCategoreyDescending;
import com.designpatterns.ab.strategy.SortManufacturerAscending;
import com.designpatterns.ab.strategy.SortManufacturerDescending;
import com.designpatterns.ab.strategy.SortNameAscending;
import com.designpatterns.ab.strategy.SortNameDescending;
import com.designpatterns.ab.strategy.SortPriceDescending;
import com.designpatterns.ab.strategy.SortPriceAscending;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/item")

public class ItemController {
	@Autowired
	private ItemRepository itemRepo;
	
	//return all items
		@GetMapping("/all")
		public List<Item> getAllItems(){
			return itemRepo.findAll();
		}
		
		//get by id
		@GetMapping("/itemById/{id}")
		public ResponseEntity<Item> getUserByID(@PathVariable int id) {
			Item i = itemRepo.findById(id).get();
					//.orElseThrow(() -> new ResourceNotFoundException("Item with ID:" + id + " does not exist"));
			return ResponseEntity.ok(i);
			 
		}
		
		@GetMapping("/nameAscending")
		public List<Item> sortItemsByName(){
			List<Item> itemList = itemRepo.findAll();
			//List<Item> sortedList = new ArrayList<Item>();
			Context context = new Context(new SortNameAscending());
			return context.executeSortStrategy(itemList);
		}
		
		@GetMapping("/nameDescending")
		public List<Item> sortItemsByNameReversed(){
			List<Item> itemList = itemRepo.findAll();
			//List<Item> sortedList = new ArrayList<Item>();
			Context context = new Context(new SortNameDescending());
			return context.executeSortStrategy(itemList);
		}
		
		@GetMapping("/manufacturerAscending")
		public List<Item> sortItemsByManufacturer(){
			List<Item> itemList = itemRepo.findAll();
			Context context = new Context(new SortManufacturerAscending());
			return context.executeSortStrategy(itemList);
		}
		
		@GetMapping("/manufacturerDescending")
		public List<Item> sortItemsByManufacturerReversed(){
			List<Item> itemList = itemRepo.findAll();
			Context context = new Context(new SortManufacturerDescending());
			return context.executeSortStrategy(itemList);
		}
		
		@GetMapping("/priceDescending")
		public List<Item> priceSortDescending(){
			List<Item> itemList = itemRepo.findAll();
			Context context = new Context(new SortPriceDescending());
			return context.executeSortStrategy(itemList);
		}
		
		@GetMapping("/priceAscending")
		public List<Item> priceSortAscending(){
			List<Item> itemList = itemRepo.findAll();
			Context context = new Context(new SortPriceAscending());
			return context.executeSortStrategy(itemList);
		}
		
		@GetMapping("/typeDescending")
		public List<Item> typeSortDescending(){
			List<Item> itemList = itemRepo.findAll();
			Context context = new Context(new SortCategoreyDescending());
			return context.executeSortStrategy(itemList);
		}
		
		@GetMapping("/typeAscending")
		public List<Item> typePriceAscending(){
			List<Item> itemList = itemRepo.findAll();
			Context context = new Context(new SortCategoreyAscending());
			return context.executeSortStrategy(itemList);
		}
		
		
		
		// Search method
		@GetMapping("/search/{item}")
		public List<Item> searchItem(@PathVariable String item) {
			return itemRepo.searchItem(item);
			 
		}
		
		//create user
		@PostMapping("/addItem")
		public Item addUser(@RequestBody Item i) {
			return itemRepo.save(i);
		}
		
		//update user
		@PutMapping("/updateItem/{id}")
		public ResponseEntity<Item> updateUser(@PathVariable int id, @RequestBody Item i){
			Item item = itemRepo.findById(id).get();
					//.orElseThrow(() -> new ResourceNotFoundException("Employee with ID:" + id + " does not exist"));
			item.setName(i.getName());
			item.setPrice(i.getPrice());
			item.setManufacturer(i.getManufacturer());
			item.setPrice(i.getPrice());
			item.setStock(i.getStock());
			item.setType(i.getType());
			Item updatedItem = itemRepo.save(item);
			return ResponseEntity.ok(updatedItem);
		}
		
		// Delete a booking
		@DeleteMapping("/deleteItem/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) {
			Item item = itemRepo.findById(id).get();
					//.orElseThrow(() -> new ResourceNotFoundException("Employee with ID:" + id + " does not exist"));
			itemRepo.delete(item);
			Map<String, Boolean> itemDeleted = new HashMap<String, Boolean>();
			itemDeleted.put("Item deleted", Boolean.TRUE);

			return ResponseEntity.ok(itemDeleted);
		}
	
}
