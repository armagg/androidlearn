package com.yektanet.omid.weather;

class ListComponent {
    private String cityName;
    private int Temperature;
    private JsonHandler jsonHandler;
    public ListComponent(String cityName, int temperature, JsonHandler jsonHandler) {
        this.jsonHandler = jsonHandler;
        this.cityName = cityName;
        Temperature = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public int getTemperature() {
        return Temperature;
    }

    public JsonHandler getJsonHandler() {
        return jsonHandler;
    }

    public void setJsonHandler(JsonHandler jsonHandler) {
        this.jsonHandler = jsonHandler;
    }


}
