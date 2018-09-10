package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class ItemFilterController {

	@Autowired
	private ItemProxy proxy;
	
	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/good-items")
	@CrossOrigin(origins = "*")
	public Collection<Item> goodItems() {
		return proxy.readItems().getContent().stream().filter(this::isGreat).collect(Collectors.toList());
	}
	
	 private boolean isGreat(Item item) {
	        return item.getName().equals("Pen") ||
	                item.getName().equals("Light") ||
	                item.getName().equals("Yoga");

	 }
	 
	 public Collection<Item> fallback() {
		    return new ArrayList<>();
	 }
	

}
