package com.example.n11_final_case.controller;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.service.RecommendationService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;
    private final static String recommendationURL = "http://localhost:8081/api/v1/restaurant/getAll";

    @GetMapping()
    public String getRestaurants(){
        RestTemplate restTemplate = new RestTemplate();
        String string = restTemplate.getForObject(recommendationURL, String.class);
        return string;
    }


    @GetMapping("/{id}")
    public List recommendationRestaurant(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        String string = restTemplate.getForObject(recommendationURL,String.class);

        JsonArray convertedObject = new Gson().fromJson(string, JsonArray.class);
        return recommendationService.recommendationRestaurant(convertedObject, id);
    }





}
