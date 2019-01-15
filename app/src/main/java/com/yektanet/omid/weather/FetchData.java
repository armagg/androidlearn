package com.yektanet.omid.weather;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

class FetchData extends AsyncTask<Void, Void, Void> {
    private String address;
    private String fetchedData = "";

    FetchData(String address)  {
        this.address= address;

    }
    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL(address);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream input = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            String line = "";
            while (line !=null){
                line = bufferedReader.readLine();
                fetchedData +=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void avoid){
        super.onPostExecute(avoid);
    }

    String getFetchedData() {
        return fetchedData;
    }
}
