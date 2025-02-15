package com.amitu.foodcatalouge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitu.foodcatalouge.dto.FoodCataloguePage;
import com.amitu.foodcatalouge.dto.FoodItemDto;
import com.amitu.foodcatalouge.service.FoodCatalougeService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

	private final FoodCatalougeService foodCatalougeService;

	public FoodCatalogueController(FoodCatalougeService foodCatalougeService) {
		this.foodCatalougeService = foodCatalougeService;
	}

	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDTO) {
		FoodItemDto foodItemSaved = foodCatalougeService.addFoodItem(foodItemDTO);
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
	}

	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodCataloguePage> fetchRestauDetailsWithFoodMenu(@PathVariable Integer restaurantId) {
		FoodCataloguePage foodCataloguePage = foodCatalougeService.fetchFoodCataloguePageDetails(restaurantId);
		return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);

	}

}
