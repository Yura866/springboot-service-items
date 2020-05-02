package com.springboot.app.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.app.item.models.Item;
import com.springboot.app.item.models.Product;
import com.springboot.app.item.service.ItemService;

@RestController
public class ItemController {
	private static Logger log = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	@Qualifier("serviceFeign")
	ItemService itemService;
	
	@Value("${configuracion.texto}")
	private String text;
	
	@GetMapping("/list")
	public List<Item> list(){		
		return itemService.findAll();
	}
	
	@HystrixCommand(fallbackMethod="alternativeMetode")
	@GetMapping("/see/{id}/amount/{amount}")
	public Item detail(@PathVariable Long id, @PathVariable Integer amount) {
		return itemService.findById(id, amount);
	}
	
	public Item alternativeMetode(@PathVariable Long id, @PathVariable Integer amount) {
		Item item = new Item();
		Product product = new Product();
		item.setAmount(amount);
		product.setId(id);
		product.setName("Nike");
		product.setPrice(600.00);
		item.setProduct(product);
		
		return item;
	}
	
	@GetMapping("/retriev-config")
	public ResponseEntity<?> retrievConfig(@Value("${server.port}") String port){
		log.info(text);
		Map<String, String> json  = new HashMap<>();
		json.put("text","text");
		json.put("port",port);
		
		return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
	}
	
}
