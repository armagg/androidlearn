package com.yektanet.omid.weather;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class List extends BaseAdapter {
    private MainActivity mainActivity;
    private View view;

    public List(ArrayList<ListComponent> list) {
        this.list = list;
    }

    ArrayList<ListComponent> list ;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        view = mainActivity.getLayoutInflater().inflate(R.layout.customlayout, null);
        TextView cityName = view.findViewById(R.id.city_name);
        TextView temp = view.findViewById(R.id.temperature);
        cityName.setText(list.get(position).getCityName());
        temp.setText(list.get(position).getTemperature());
        return view;
    }



}
