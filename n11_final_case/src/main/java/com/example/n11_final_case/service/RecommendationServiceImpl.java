package com.example.n11_final_case.service;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.dao.UserDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;

import static java.lang.Math.*;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService{

    private final UserDao userDao;

    public double calcDistance(JsonElement latitude, JsonElement longitude, int id) {
        double userLatitude = userDao.getById(id).getLatitude();
        double userLongitude = userDao.getById(id).getLongitude();

        return abs(sqrt(
                pow(userLatitude - latitude.getAsDouble(),2) + pow(userLongitude - longitude.getAsDouble(),2))
        );
    }
    public double calcCommendation(JsonElement latitude, JsonElement longitude, int id, JsonElement point) {
        double userLatitude = userDao.getById(id).getLatitude();
        double userLongitude = userDao.getById(id).getLongitude();
        double pointResult = point.getAsDouble() * 70 / 100;
        double milResult = abs(sqrt(
                        pow(userLatitude - latitude.getAsDouble(),2) + pow(userLongitude - longitude.getAsDouble(),2))
                              ) * 30 / 100;
        double result = pointResult + milResult;
        return result;
    }

    public List recommendationRestaurant(JsonArray jsonArray, int id) {
        JsonArray j = new JsonArray();
        for (JsonElement o : jsonArray){
            JsonObject innerObject = new JsonObject();
            if(calcDistance(o.getAsJsonObject().get("latitude")
                    ,o.getAsJsonObject().get("longitude")
                    ,id)>10) continue;
            innerObject.addProperty("distance",calcDistance(o.getAsJsonObject().get("latitude")
                    ,o.getAsJsonObject().get("longitude")
                    ,id));
            innerObject.addProperty("recommendationPoint", calcCommendation(o.getAsJsonObject().get("latitude")
                    ,o.getAsJsonObject().get("longitude")
                    ,id
                    ,o.getAsJsonObject().get("point")));
            innerObject.add("name",o.getAsJsonObject().get("name"));
            innerObject.add("point",o.getAsJsonObject().get("point"));

            j.add(innerObject);
        }

        Type listType = new TypeToken<List>() {}.getType();
        List resultList = new ArrayList();
        resultList = new Gson().fromJson(j,listType);

        Collections.sort(resultList,new Comparator<LinkedTreeMap>(){
            @Override
            public int compare(LinkedTreeMap a, LinkedTreeMap b ) {
                return Double.compare((Double) a.get("recommendationPoint"), (Double) b.get("recommendationPoint"));
            }
        });

        for(int i = resultList.size() - 1; i>=3; i--){
            resultList.remove(i);
        }
        return resultList.reversed();
    }
}
