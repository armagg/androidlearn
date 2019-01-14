package com.yektanet.omid.weather;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    JsonHandler jsonHandler;

    final static String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        String s = "{\"coord\":{\"lon\":51.42,\"lat\":35.69},\"weather\":[{\"id\":741,\"main\":\"Fog\"" +
                ",\"description\":\"fog\",\"icon\":\"50d\"},{\"id\":701,\"main\":\"Mist\",\"description\":" +
                "\"mist\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":275.08,\"pressure\"" +
                ":1015,\"humidity\":91,\"temp_min\":273.15,\"temp_max\":277.15},\"visibility\":10000,\"wind\":" +
                "{\"speed\":2.1,\"deg\":120},\"clouds\":{\"all\":90},\"dt\":1547445600,\"sys\":{\"type\":1,\"id\"" +
                ":7464,\"message\":0.002,\"country\":\"IR\",\"sunrise\":1547437426,\"sunset\":1547473387},\"id\":112931,\"" +
                "name\":\"Tehran\",\"cod\":200}";

            new JsonHandler(s, City.TEHRAN);
*/
        TextView textView = findViewById(R.id.text);
        String s = null;
        JsonHandler jsonHandler;
        /*try {
            Network network = new Network(City.TEHRAN);
            jsonHandler = network.getJsonHandler();
            s = jsonHandler.getJson();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (s != null)
        textView.setText(s);
*/
        FetchData fetchData = null;

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


    @Override
    protected void onResume() {
        super.onResume();
        //registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }




    @SuppressLint("ShowToast")
    public void onClick(View view) {
    }


    private PendingIntent creatPIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        return PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
    }


}
