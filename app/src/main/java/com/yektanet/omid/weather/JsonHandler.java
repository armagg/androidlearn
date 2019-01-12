package com.yektanet.omid.weather;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.PriorityQueue;

class JsonHandler {
    private String Json ;
    private JSONObject reader;
    private boolean isOkay = true;
    private WindDirect windDirect;


    private String city;
    private String main;
    private String description;
    private int humidity;
    private float temp;
    private float minTemp;
    private float maxTem;

    JsonHandler(String json){
        this.Json = json;
        try {
            reader = new JSONObject(json);
        } catch (JSONException e) {
            isOkay = false;
            e.printStackTrace();
        }


    }
}
