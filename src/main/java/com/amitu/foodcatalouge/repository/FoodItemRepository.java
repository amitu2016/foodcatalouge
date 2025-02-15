package com.amitu.foodcatalouge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amitu.foodcatalouge.entity.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
	
	List<FoodItem> findByRestaurantId(Integer restaurantId);

}
