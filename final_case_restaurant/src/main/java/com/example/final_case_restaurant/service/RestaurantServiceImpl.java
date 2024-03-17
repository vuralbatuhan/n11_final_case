package com.example.final_case_restaurant.service;

/*
 * @author batuhanvural
 */

import com.example.final_case_restaurant.dao.RestaurantDao;
import com.example.final_case_restaurant.dto.RestaurantDto;
import com.example.final_case_restaurant.entity.Restaurant;
import com.example.final_case_restaurant.util.LoggerHandler;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantDao restaurantDao;
    private final ModelMapper modelMapper;

    public List<RestaurantDto> getAllRestaurant() {
        List<Restaurant> restaurantList = restaurantDao.getAllRestaurant();
        List<RestaurantDto> restaurantDtoList = restaurantList.stream().map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class)).collect(Collectors.toList());
        return restaurantDtoList;
    }

    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        LoggerHandler.getLogger().log(Level.INFO,
                "RestaurantServiceImpl --> createRestaurant() New restaurant has been created");
        Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
        return modelMapper.map(restaurantDao.save(restaurant), RestaurantDto.class);
    }

    public RestaurantDto getFindByIdRestaurant(int id) {
        return modelMapper.map(restaurantDao.getIdBy(id), RestaurantDto.class);
    }

}
