package com.example.final_case_restaurant.controller;

/*
 * @author batuhanvural
 */

import com.example.final_case_restaurant.dto.RestaurantDto;
import com.example.final_case_restaurant.dto.SendRestaurantDto;
import com.example.final_case_restaurant.exception.RestaurantNotFoundException;
import com.example.final_case_restaurant.service.RestaurantService;
import com.example.final_case_restaurant.util.LoggerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {


    private final RestaurantService restaurantService;

    @GetMapping("/getAll")
    public List<RestaurantDto> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    @PostMapping("/createRestaurant")
    public RestaurantDto createRestaurant(@RequestBody RestaurantDto restaurant) {
        LoggerHandler.getLogger().log(Level.INFO,
                "RestaurantController --> createRestaurant() --> restaurant has been sent to RestaurantService createRestaurant()");
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("{id}/restaurants")
    public SendRestaurantDto getFindByIdRestaurant(@PathVariable int id){
        try{
            return new SendRestaurantDto(
                    restaurantService.getFindByIdRestaurant(id).getId(),
                    restaurantService.getFindByIdRestaurant(id).getName(),
                    restaurantService.getFindByIdRestaurant(id).getLatitude(),
                    restaurantService.getFindByIdRestaurant(id).getLongitude(),
                    restaurantService.getFindByIdRestaurant(id).getPoint());
        }catch(Exception e){
            throw new RestaurantNotFoundException("There is no such restaurant. Please check id");
        }
    }



}
