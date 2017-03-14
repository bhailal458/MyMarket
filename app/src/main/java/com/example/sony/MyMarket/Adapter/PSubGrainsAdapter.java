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
import com.example.sony.MyMarket.PojoClass.PojoGrains;
import com.example.sony.MyMarket.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sony on 02-03-2017.
 */

public class PSubGrainsAdapter extends BaseAdapter {

    private Context context1;
    private LayoutInflater inflater;
    private ArrayList<PojoGrains> mygrainspojo;
    //private final String[] webgrains;
    private OneProductFragment oneproductfrag;

    public PSubGrainsAdapter(Context context1, ArrayList<PojoGrains> mygrainspojo) {
        this.context1 = context1;
        this.mygrainspojo = mygrainspojo;
        //this.webgrains = webgrains;
    }


    @Override
    public int getCount() {
        return mygrainspojo.size();
    }

    @Override
    public Object getItem(int position) {
        return mygrainspojo.get(position);
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

        final PojoGrains pg = mygrainspojo.get(position);

        imageView.setImageResource(pg.getImggrains());
        txtTitle.setText(pg.getWebgrains());

        Picasso.with(context1).load(pg.getImggrains()).resize(100,100).into(imageView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                oneproductfrag = new OneProductFragment();
                Bundle bundle = new Bundle();
                int myPos = pg.getImggrains();
                String myString = pg.getWebgrains();

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
