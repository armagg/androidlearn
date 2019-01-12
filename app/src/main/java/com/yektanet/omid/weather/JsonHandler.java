package com.yektanet.omid.weather;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.PriorityQueue;

class JsonHandler {
    private String Json ;
    private JSONObject reader;
    private boolean isOkay = true;
    private WindDirect windDirect;

    private String mainWeather;
    private String description;
    private int humidity;
    private float temp;
    private float minTemp;
    private float maxTemp;
    private double windSpeed;
    private int windDegree;
    JsonHandler(String json){
        this.Json = json;
        try {
            reader = new JSONObject(json);
            init();
        } catch (JSONException e) {
            isOkay = false;
            e.printStackTrace();
        }



    }

    private void init() throws JSONException {
        JSONObject weather = reader.getJSONObject("weather");
        JSONObject main = reader.getJSONObject("main");
        JSONObject wind = reader.getJSONObject("wind");

        mainWeather = weather.getString("main");
        description = weather.getString("description");
        humidity = main.getInt("humidity");
        temp = getTempInCelcius(main.getDouble("temp"));
        minTemp = getTempInCelcius(main.getDouble("min_temp"));
        maxTemp = getTempInCelcius(main.getDouble("max_temp"));
        windSpeed = wind.getDouble("speed");
        windDegree = wind.getInt("deg");

    }

    private float getTempInCelcius(double temp) {
        return (float) (temp - 273.3);
    }
}
