package com.amitu.foodcatalouge.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amitu.foodcatalouge.dto.FoodCataloguePage;
import com.amitu.foodcatalouge.dto.FoodItemDto;
import com.amitu.foodcatalouge.dto.Restaurant;
import com.amitu.foodcatalouge.entity.FoodItem;
import com.amitu.foodcatalouge.mapper.FoodItemMapper;
import com.amitu.foodcatalouge.repository.FoodItemRepository;

@Service
public class FoodCatalougeService {
	
	private final FoodItemRepository repo;
	
	private final RestTemplate restTemplate;
	
	public FoodCatalougeService(FoodItemRepository repo, RestTemplate restTemplate) {
		this.repo = repo;
		this.restTemplate = restTemplate;
	}
	
	public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItemSavedInDB = repo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemSavedInDB);
    }

	 public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
	        List<FoodItem> foodItemList =  fetchFoodItemList(restaurantId);
	        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
	        return createFoodCataloguePage(foodItemList, restaurant);
	    }

	    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
	        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
	        foodCataloguePage.setFoodItemsList(foodItemList);
	        foodCataloguePage.setRestaurant(restaurant);
	        return foodCataloguePage;
	    }

	    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
	       return restTemplate.getForObject("http://RESTAURANTLISTING/restaurant/fetchById/"+restaurantId, Restaurant.class);
	    }

	    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
	        return repo.findByRestaurantId(restaurantId);
	    }

}
