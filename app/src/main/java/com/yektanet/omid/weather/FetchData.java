package com.yektanet.omid.weather;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

class FetchData extends AsyncTask<Void, Void, Void> {
    private String address;
    private String fetchedData = "";
    private City city;
    private JsonHandler jsonHandler;

    public FetchData(String address, City city) {
        this.address = address;
        this.city = city;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(address);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream input = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                fetchedData += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void avoid) {
        super.onPostExecute(avoid);
        jsonHandler = new JsonHandler(getFetchedData(), city);

    }

    String getFetchedData() {
        return fetchedData;
    }

    public JsonHandler getJsonHandler() {
        return jsonHandler;
    }


}
