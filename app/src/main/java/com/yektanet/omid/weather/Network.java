package com.yektanet.omid.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class Network {
    private JsonHandler jsonHandler;
    public Network(City city) throws Exception {
        String  address=Contants.getAddress(city);
        jsonHandler = new JsonHandler(HTTPGetCall(address), city);
    }



    private static String HTTPGetCall(String WebMethodURL) throws IOException, MalformedURLException
    {
        StringBuilder response = new StringBuilder();

        URL u = new URL(WebMethodURL);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()),8192);
            String line;

            while ((line = input.readLine()) != null)
            {
                response.append(line);
            }
            input.close();
        }
        return response.toString();
    }

    public JsonHandler getJsonHandler() {
        return jsonHandler;
    }
}
