package com.yektanet.omid.weather;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    HashMap<City, Intent> intents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private Intent intentCreator(JsonHandler j) {
        Intent intent = new Intent(this, oneCityViewer.class);
        intent.putExtra("isOkay", j.isOkay());
        if (j.isOkay()) {
            intent.putExtra("city", j.getCity());
            intent.putExtra("windDirect", j.getWindDirect());
            intent.putExtra("mainWeather", j.getMainWeather());
            intent.putExtra("description", j.getDescription());
            intent.putExtra("humidity", j.getHumidity());
            intent.putExtra("temp", j.getTemp());
            intent.putExtra("minTemp", j.getMinTemp());
            intent.putExtra("maxTemp", j.getMaxTemp());
            intent.putExtra("windSpeed", j.getWindSpeed());
        }
        return intent;
    }

    private PendingIntent creatPIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        return PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
    }

    private void initialJsons() throws Exception {

            int step = 0;
        for (final City city : City.values()) {
             new FetchData(Contants.getAddress(city), city, new UpdateCity() {
                @Override
                public void setContent(JsonHandler jsonHandler, int n, boolean isMain) {
                    intents.put(city, intentCreator(jsonHandler));


                }
            }, step).execute();

        }
    }





}
