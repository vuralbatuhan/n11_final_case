package com.example.final_case_restaurant.service;

/*
 * @author batuhanvural
 */

import com.example.final_case_restaurant.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDto> getAllRestaurant();

    RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    RestaurantDto getFindByIdRestaurant(int id);

}
