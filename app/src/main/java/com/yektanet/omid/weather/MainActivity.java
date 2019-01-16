package com.yektanet.omid.weather;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView cityName;
    TextView temp;
    TextView maxTemp;
    TextView minTemp;
    TextView windSpeed;
    TextView windDirect;


    HashMap<City, Intent> intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    static Intent intentCreator(JsonHandler j) {
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
        ArrayList<ListComponent> list = new ArrayList<>(5);




    }
}

/*

        if (isMain) {
        cityName = findViewById(R.id.main_city);
        temp = findViewById(R.id.main_temp);
        minTemp = findViewById(R.id.main_min_temp);
        maxTemp = findViewById(R.id.main_max_temp);
        windSpeed = findViewById(R.id.main_wind_speed);
        windDirect = findViewById(R.id.main_wind_direct);
        cityName.setText(jsonHandler.getCity().toString());
        temp.setText(String.valueOf(jsonHandler.getTemp()));
        minTemp.setText(String.valueOf(jsonHandler.getMinTemp()));
        maxTemp.setText(String.valueOf(jsonHandler.getMaxTemp()));
        windSpeed.setText((String.valueOf(jsonHandler.getWindSpeed())));
        windDirect.setText(jsonHandler.getWindDirect().toString());
*/
