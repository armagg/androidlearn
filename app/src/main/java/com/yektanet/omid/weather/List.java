package com.yektanet.omid.weather;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.sip.SipSession;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class List extends BaseAdapter {
    private MainActivity mainActivity;
    private View view;

    public List(ArrayList<JsonHandler> list, MainActivity mainActivity) {
        this.list = list;
        this.mainActivity = mainActivity;
    }

    ArrayList<JsonHandler> list ;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        view = mainActivity.getLayoutInflater().inflate(R.layout.customlayout, null);
        TextView cityName = view.findViewById(R.id.city_name);
        TextView temp = view.findViewById(R.id.temperature);
        cityName.setText(list.get(position).getCity().toString());
        temp.setText(String.valueOf(list.get(position).getTemp()));
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivity.intentCreator(list.get(position));
                mainActivity.startActivity(intent);
            }
        });
        return view;
    }



}
