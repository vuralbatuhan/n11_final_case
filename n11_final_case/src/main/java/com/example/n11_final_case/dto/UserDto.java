package com.example.n11_final_case.dto;

/*
 * @author batuhanvural
 */

import lombok.Builder;
import lombok.Data;

//@Builder
@Data
public class UserDto {
    private int id;
    private String name;
    private String surname;
    private int age;
    private double latitude;
    private double longitude;
}
