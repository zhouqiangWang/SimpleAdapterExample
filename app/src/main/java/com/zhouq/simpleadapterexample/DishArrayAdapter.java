package com.zhouq.simpleadapterexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/6.
 */
public class DishArrayAdapter extends ArrayAdapter<Map<String,String>> {

    List<Map<String,String>> data;

    public DishArrayAdapter(Context context, int resource, int textViewResourceId, List<Map<String, String>> objects) {
        super(context, resource, textViewResourceId, objects);
        data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        Map<String,String> curMap = data.get(position);

        ImageView imageView = (ImageView) view.findViewById(R.id.grid_image);
        int imgResId = Integer.parseInt(curMap.get("album"));
        imageView.setImageResource(imgResId);

        TextView titleText = (TextView) view.findViewById(R.id.title);
        TextView artistText = (TextView) view.findViewById(R.id.artist);

        titleText.setText(curMap.get("title"));
        artistText.setText(curMap.get("artist"));

        return view;
    }
}
