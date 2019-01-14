package com.yektanet.omid.weather;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

class FetchData extends AsyncTask<Void, Void, Void> {
    private URL url;
    FetchData(String address) throws IOException {
    {
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
    }}

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(Void avoid){
        super.onPostExecute(avoid);
    }
}
