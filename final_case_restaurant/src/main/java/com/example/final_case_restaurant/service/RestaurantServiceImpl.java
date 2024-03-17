package com.example.final_case_restaurant.service;

/*
 * @author batuhanvural
 */

import com.example.final_case_restaurant.dao.RestaurantDao;
import com.example.final_case_restaurant.dto.RestaurantDto;
import com.example.final_case_restaurant.entity.Restaurant;
import com.example.final_case_restaurant.exception.RestaurantNotFoundException;
import com.example.final_case_restaurant.util.LoggerHandler;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public RestaurantDto deleteRestaurant(int id) {
        Restaurant restaurant = restaurantDao.findById(id).orElseThrow(() -> new RestaurantNotFoundException("There is no such restaurant. Please check restaurant id"));
        restaurantDao.delete(restaurantDao.getIdBy(id));
        LoggerHandler.getLogger().log(Level.INFO,
                "RestaurantServiceImpl --> deleteRestaurant() --> Restaurant deleted by id");
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    public RestaurantDto updateRestaurant(int id, RestaurantDto restaurant) {
        Optional<Restaurant> resultRestaurant = Optional.ofNullable(restaurantDao.findById(id).orElseThrow(() -> new RestaurantNotFoundException("There is no such restaurant. Please check restaurant id")));
        if(resultRestaurant.isPresent()) {
            resultRestaurant.get().setId(restaurant.getId());
            resultRestaurant.get().setName(restaurant.getName());
            resultRestaurant.get().setPoint(restaurant.getPoint());
            resultRestaurant.get().setLatitude(restaurant.getLatitude());
            resultRestaurant.get().setLongitude(restaurant.getLongitude());
            LoggerHandler.getLogger().log(Level.INFO,
                    "RestaurantServiceImpl --> updateRestaurant() --> Restaurant updated by id");
            return modelMapper.map(restaurantDao.save(resultRestaurant.get()), RestaurantDto.class);
        }else {
            return null;
        }
    }

}
