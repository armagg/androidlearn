package com.yektanet.omid.weather;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
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
    ArrayList<JsonHandler> list;
    View view;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            initialJsons();
        }catch (Exception e){
            e.printStackTrace();
        }
        listView = findViewById(R.id.list_view);
       // System.out.println("ghabl for e man");
        for (JsonHandler j: list){
         //   System.out.println("my for hahah");
            System.out.println(j.toString());
        }

        listView.setAdapter(getAsListAdapter(list));

    }

    private ListAdapter getAsListAdapter(ArrayList<JsonHandler> list) {
        return new List(list, this);
    }


    private void initialJsons() throws Exception {
        list = new ArrayList<>(5);
        int step = 0;
        for (City city : City.values()){
            if (city == City.TEHRAN){
              view = findViewById(R.id.main_view);
              FetchData fetchData = new FetchData(city, new UpdateCity() {
                  @Override
                  public void setContent(final JsonHandler jsonHandler, int n, boolean isMain) {
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
                      Button button = findViewById(R.id.main_button);
                      button.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              Intent intent = intentCreator(jsonHandler);
                              startActivity(intent);
                          }
                      });
                  }
              }, step);
              fetchData.execute();

            }else{

                Log.d(city.toString(), " vared shod");
                new FetchData(city, new UpdateCity() {
                    @Override
                    public void setContent(JsonHandler jsonHandler, int n, boolean isMain) {
                        list.add(jsonHandler);
                    }
                }, step).execute();
            }
            step++;
        }



    }






    private PendingIntent creatPIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        return PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
    }

    Intent intentCreator(JsonHandler j) {
        Intent intent = new Intent(MainActivity.this, oneCityViewer.class);
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
}

/*

        if (isMain) {

*/
