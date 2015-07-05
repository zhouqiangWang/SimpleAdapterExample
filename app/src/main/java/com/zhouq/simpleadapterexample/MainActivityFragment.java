package com.zhouq.simpleadapterexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    List<Map<String,String>> listData;
    int[] imageResIds = new int[]{
            R.drawable.chrysanthemum,R.drawable.desert,R.drawable.hydrangeas
    };

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridView gridView = (GridView) view.findViewById(R.id.grid_view);

        listData = new ArrayList<Map<String,String >>();
        for (int i=0;i<3;i++){
            Map<String,String> map = new HashMap<String,String>();
            map.put("title", "title "+(i+1));
            map.put("artist", "artist "+(i+1));
            map.put("album", String.valueOf(imageResIds[i]));
            listData.add(map);
        }

//        SimpleAdapter gridAdpter = new SimpleAdapter(this.getActivity(),listData,R.layout
//                .grid_item,new String[]{"title","artist"},new int[]{R.id.title,
//                R.id.artist} );

        DishArrayAdapter adapter = new DishArrayAdapter(this.getActivity(),R
                .layout.grid_item ,R.id.title ,listData);

        gridView.setAdapter(adapter);
    }
}
