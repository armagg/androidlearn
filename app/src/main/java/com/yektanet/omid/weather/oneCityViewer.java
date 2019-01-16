package com.yektanet.omid.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class oneCityViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_city_viewer);
        setContents();
    }

    private void setContents() {
        Bundle bundle = getIntent().getExtras();
        TextView cityName = findViewById(R.id.second_page_city);
        TextView temp = findViewById(R.id.second_page_temp);
        TextView minTemp = findViewById(R.id.second_page_min_temp);
        TextView maxTemp = findViewById(R.id.second_page_max_temp);
        TextView main = findViewById(R.id.second_page_main);
        TextView description = findViewById(R.id.second_page_description);
        TextView windSpeed = findViewById(R.id.second_page_wind_speed);
        TextView windDirect = findViewById(R.id.second_page_wind_direct);
        if ((boolean) bundle.get("isOkay")) {
            cityName.setText(String.valueOf(bundle.get("city")));
            temp.setText(String.valueOf(bundle.get("windDirect")));
            main.setText(String.valueOf(bundle.get("mainWeather")));
            description.setText(String.valueOf(bundle.get("description")));
            minTemp.setText(String.valueOf("minTemp"));
            maxTemp.setText(String.valueOf("maxTemp"));
            windSpeed.setText(String.valueOf(bundle.get("windSpeed")));
            windDirect.setText(String.valueOf(bundle.get("windDirect")));
        }
    }
}
