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
