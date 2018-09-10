package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("item-catalog-service")
//@RibbonClient(name="item-catalog-service")
public interface ItemProxy {
	
	@GetMapping("/items")
	Resources<Item> readItems();
}
