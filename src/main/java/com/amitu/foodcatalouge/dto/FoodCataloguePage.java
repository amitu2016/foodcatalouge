package com.amitu.foodcatalouge.dto;

import java.util.List;

import com.amitu.foodcatalouge.entity.FoodItem;

public class FoodCataloguePage {
	
	private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
    
	public FoodCataloguePage() {
		// TODO Auto-generated constructor stub
	}

	public FoodCataloguePage(List<FoodItem> foodItemsList, Restaurant restaurant) {
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
	}

	public List<FoodItem> getFoodItemsList() {
		return foodItemsList;
	}

	public void setFoodItemsList(List<FoodItem> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "FoodCataloguePage [foodItemsList=" + foodItemsList + ", restaurant=" + restaurant + "]";
	}
	
    

}
