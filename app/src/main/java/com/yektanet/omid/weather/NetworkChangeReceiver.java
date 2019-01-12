package com.yektanet.omid.weather;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
    Intent intent;
    final static String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    Context context;
    @Override
    public void onReceive(final Context context, final Intent intent) {
        System.out.println("vared shod ");
        this.context = context;
        this.intent = intent;
        String actionOfIntent = intent.getAction();
        boolean isConnected = hasInternet();
        if (actionOfIntent.equals(CONNECTIVITY_ACTION)) {
            if (isConnected) {
                loadData();
            } else {
                updateUI();
            }
        }


    }


    public boolean hasInternet() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();


    }

    void loadData() {
        Log.d("my load data ", "flag 1021");

    }

    void updateUI() {
        // No internet connection, update the ui and warn the user

        Log.d("no internet", "flag 791");
    }


}

