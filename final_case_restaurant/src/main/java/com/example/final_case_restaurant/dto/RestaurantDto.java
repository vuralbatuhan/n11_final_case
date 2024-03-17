package com.example.final_case_restaurant.dto;

/*
 * @author batuhanvural
 */

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class RestaurantDto {

    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private int point;

}
