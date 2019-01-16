package com.yektanet.omid.weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.PriorityQueue;

class JsonHandler {
    private String Json ;
    private JSONObject reader;
    private boolean isOkay = true;
    private WindDirect windDirect;
    private City city;
    private String mainWeather;
    private String description;
    private int humidity;
    private float temp;
    private float minTemp;
    private float maxTemp;
    private double windSpeed;
    private int windDegree;
    JsonHandler(String json, City city){
        this.Json = json;
        this.city = city;
        try {
            reader = new JSONObject(json);
            init();
        } catch (JSONException e) {
            isOkay = false;
            e.printStackTrace();
        }



    }

    private void init() throws JSONException {
        JSONArray weather = reader.getJSONArray("weather");
        System.out.println(weather.toString());
        JSONObject main = reader.getJSONObject("main");
        System.out.println(main.toString());
        JSONObject wind = reader.getJSONObject("wind");
        System.out.println(wind.toString());

        mainWeather = weather.getJSONObject(0).getString("main");
        System.out.println(mainWeather);
        description = weather.getJSONObject(0).getString("description");
        System.out.println(description);
        humidity = main.getInt("humidity");
        System.out.println(humidity);
        temp = getTempInCelcius(main.getDouble("temp"));
        System.out.println(temp);
        minTemp = getTempInCelcius(main.getDouble("temp_min"));
        System.out.println(minTemp);
        maxTemp = getTempInCelcius(main.getDouble("temp_max"));
        System.out.println(maxTemp);
        windSpeed = wind.getDouble("speed");
        System.out.println(windSpeed);
        windDegree = wind.getInt("deg");

        setWindDirect(windDegree);
        System.out.println(windDegree);
    }

    private void setWindDirect(int windDegree) {
        if ((windDegree>=0 && windDegree<=45)|| (windDegree<365 && windDegree>=315)){
            windDirect=WindDirect.EAST;
        }
        else if ((windDegree>=45 && windDegree<=135)){
            windDirect = WindDirect.NORTH;
        }
        else if ((windDegree>=135 && windDegree<=225)){
            windDirect = WindDirect.EAST;
        }
        else {
            windDirect = WindDirect.SOUTH;
        }
    }

    private static float getTempInCelcius(double temp) {
        return (float) (temp - 273.3);
    }

    boolean isOkay() {
        return isOkay;
    }

    String getJson() {
        return Json;
    }

    City getCity() {
        return city;
    }

    WindDirect getWindDirect() {
        return windDirect;
    }

    String getMainWeather() {
        return mainWeather;
    }

    public String getDescription() {
        return description;
    }

    int getHumidity() {
        return humidity;
    }

    float getTemp() {
        return temp;
    }

    float getMinTemp() {
        return minTemp;
    }

    float getMaxTemp() {
        return maxTemp;
    }

    double getWindSpeed() {
        return windSpeed;
    }

    @Override
    public String toString() {
        return getCity().toString() + "\t " + getTemp()+ "\n";
    }
}
