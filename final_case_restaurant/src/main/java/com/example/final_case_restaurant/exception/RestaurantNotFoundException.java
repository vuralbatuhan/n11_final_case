package com.example.final_case_restaurant.exception;

/*
 * @author batuhanvural
 */

public class RestaurantNotFoundException extends RuntimeException{

    public RestaurantNotFoundException(String message){
        super(message);
    }

}
