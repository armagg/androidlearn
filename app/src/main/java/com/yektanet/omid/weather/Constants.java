package com.yektanet.omid.weather;

public class Constants {
    private static final String braziliaAddress = "https://api.openweathermap.org/data/2.5/weather?id=112931&appid=cd4d06d3bee9eacbc0e58e2e9cdef000";
    private static final String tehranAddress = "https://api.openweathermap.org/data/2.5/weather?id=112931&appid=cd4d06d3bee9eacbc0e58e2e9cdef000";
    private static final String londonAddress = "https://api.openweathermap.org/data/2.5/weather?id=112931&appid=cd4d06d3bee9eacbc0e58e2e9cdef000";
    private static final String losAngelesAddress = "https://api.openweathermap.org/data/2.5/weather?id=112931&appid=cd4d06d3bee9eacbc0e58e2e9cdef000";
    private static final String tokyoAddress = "https://api.openweathermap.org/data/2.5/weather?id=112931&appid=cd4d06d3bee9eacbc0e58e2e9cdef000";

    public static String getAddress(City city) throws Exception {
        if (city == City.TEHRAN){
            return tehranAddress;
        }
        else if (city == City.BRAZILIA){
            return braziliaAddress;
        }
        else if (city == City.LONDON){
            return londonAddress;
        }
        else if (city == City.LOSANGELES){
            return losAngelesAddress;
        }
        else if (city == City.TOKYO){
            return tokyoAddress;
        }
        else{
            throw new Exception();
        }
    }
}
