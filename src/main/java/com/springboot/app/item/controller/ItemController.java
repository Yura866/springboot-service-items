package com.springboot.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.item.models.Item;
import com.springboot.app.item.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	ItemService itemService;
	
	@GetMapping("/list")
	public List<Item> list(){		
		return itemService.findAll();
	}
	
	@GetMapping("/see/{id}/amount/{amount}")
	public Item detail(@PathVariable Long id, @PathVariable Integer amount) {
		return itemService.findById(id, amount);
	}
	
}
