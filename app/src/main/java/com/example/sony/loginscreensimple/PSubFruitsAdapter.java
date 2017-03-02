package com.example.sony.loginscreensimple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sony on 02-03-2017.
 */

public class PSubFruitsAdapter extends BaseAdapter {

    private Context context1;
    private LayoutInflater inflater;
    private ArrayList<PojoFruits> myfruitpojo;
    private final String[] webfruits;
    private OneProductFragment oneproductfrag;


    public PSubFruitsAdapter(Context context1, ArrayList<PojoFruits> myfruitpojo, String[] webfruits) {
        this.context1 = context1;
        this.myfruitpojo = myfruitpojo;
        this.webfruits = webfruits;
    }


    @Override
    public int getCount() {
        return myfruitpojo.size();
    }

    @Override
    public Object getItem(int position) {
        return myfruitpojo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view ==  null) {
            // LayoutInflater inflater = context1.getLayoutInflater();
            inflater = (LayoutInflater)context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_row, parent, false);
        }
        TextView txtTitle = (TextView) view.findViewById(R.id.gridText);
        ImageView imageView = (ImageView) view.findViewById(R.id.gridimage);

        PojoFruits pf = myfruitpojo.get(position);

        imageView.setImageResource(pf.getImgfruits());
        txtTitle.setText(webfruits[position]);

        Picasso.with(context1).load(pf.getImgfruits()).resize(100,100).into(imageView);

        return view;
    }
}
