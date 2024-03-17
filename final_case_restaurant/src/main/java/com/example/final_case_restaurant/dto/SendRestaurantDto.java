package com.example.final_case_restaurant.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * @author batuhanvural
 */
public record SendRestaurantDto(int id, String name, double latitude, double longitude, int point) {
}
