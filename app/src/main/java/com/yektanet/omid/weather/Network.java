package com.yektanet.omid.weather;

class Network {
    private City city;
    private  String address;
    public Network(City city) throws Exception {
        this.city = city;
        address=Contants.getAddress(city);
    }
}
