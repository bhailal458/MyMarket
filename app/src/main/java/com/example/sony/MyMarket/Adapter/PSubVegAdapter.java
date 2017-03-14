package com.example.sony.MyMarket.Adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sony.MyMarket.Fragment.OneProductFragment;
import com.example.sony.MyMarket.PojoClass.PojoVeg;
import com.example.sony.MyMarket.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sony on 01-03-2017.
 */

public class PSubVegAdapter extends BaseAdapter {

    private Context context1;
    private LayoutInflater inflater;
    private ArrayList<PojoVeg> myvegpojo;
  //  private final String[] webveg;
    private OneProductFragment oneproductfrag;

    public PSubVegAdapter(Context context1, ArrayList<PojoVeg> myvegpojo) {
        this.context1 = context1;
        this.myvegpojo = myvegpojo;
       // this.webveg = webveg1;
    }


    @Override
    public int getCount() {
        return myvegpojo.size();
    }

    @Override
    public Object getItem(int position) {
        return myvegpojo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        if(view ==  null) {
           // LayoutInflater inflater = context1.getLayoutInflater();
            inflater = (LayoutInflater)context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_row, parent, false);
        }
        TextView txtTitle = (TextView) view.findViewById(R.id.gridText);
        ImageView imageView = (ImageView) view.findViewById(R.id.gridimage);

        final PojoVeg Vv = myvegpojo.get(position);

        imageView.setImageResource(Vv.getImgveg());
        txtTitle.setText(Vv.getWebveg());


       Picasso.with(context1).load(Vv.getImgveg()).resize(100,100).into(imageView);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                oneproductfrag = new OneProductFragment();
                Bundle bundle = new Bundle();
                int myPos = Vv.getImgveg();
                String myString = Vv.getWebveg();
                bundle.putInt("myProductPos",myPos);
                bundle.putString("myString",myString);
                oneproductfrag.setArguments(bundle);

                Activity activityGrid = (Activity) context1;

                FragmentManager fragmentManager = activityGrid.getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.L_Layout,oneproductfrag);
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
