package com.amitu.foodcatalouge.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.amitu.foodcatalouge.dto.FoodItemDto;
import com.amitu.foodcatalouge.entity.FoodItem;

@Mapper
public interface FoodItemMapper {
	
	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDto foodItemDTO);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);

}
