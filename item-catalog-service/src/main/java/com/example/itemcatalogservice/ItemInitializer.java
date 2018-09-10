package com.example.itemcatalogservice;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ItemInitializer implements CommandLineRunner {

	@Autowired
	private final ItemRepository itemRepository;

	ItemInitializer(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Pen", "Book", "Yoga", "Speaker", "Light", "Candel")
				.forEach(beer -> itemRepository.save(new Item(beer)));

		itemRepository.findAll().forEach(System.out::println);
	}
}