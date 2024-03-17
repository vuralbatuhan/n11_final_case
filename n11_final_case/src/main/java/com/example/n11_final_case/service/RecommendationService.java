package com.example.n11_final_case.service;

/*
 * @author batuhanvural
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public interface RecommendationService {
    List recommendationRestaurant(JsonArray jsonArray, int id);
}
