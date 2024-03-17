package com.example.final_case_restaurant.dao;

/*
 * @author batuhanvural
 */

import com.example.final_case_restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {

    @Query("from Restaurant")
    List<Restaurant> getAllRestaurant();

    @Query("from Restaurant where id=:id ")
    Restaurant getIdBy(int id);

}
