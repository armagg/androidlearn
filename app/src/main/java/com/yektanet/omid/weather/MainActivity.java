package com.yektanet.omid.weather;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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


    }



    @Override
    protected void onResume() {
        super.onResume();
        //registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //registerReceiver(receiver, intentFilter);
    }

    // Self explanatory method




    @SuppressLint("ShowToast")
    public void onClick(View view) {
    /*    Toast.makeText(this, "vared shod ", Toast.LENGTH_LONG).show();
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this);

        notifBuilder.setContentText("this is my first notif");
        notifBuilder.setSubText("hahaha ");
        notifBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(001, notifBuilder.build());
    */}


    private PendingIntent creatPIntent(){
        Intent intent = new Intent(this, MainActivity.class);
        return PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
    }



}
