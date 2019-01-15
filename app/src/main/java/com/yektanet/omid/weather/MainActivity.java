package com.yektanet.omid.weather;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
            intent.putExtra("mainWeather",j.getMainWeather() );
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


}
