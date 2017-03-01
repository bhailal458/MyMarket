package com.example.sony.loginscreensimple;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

/**
 * Created by Sony on 01-03-2017.
 */

public class PSubCategoryAdapter extends ArrayAdapter<String> {
    private Activity context1;
    private LayoutInflater inflater;
    private int[] img;
    private final String[] web;
    private OneProductFragment oneproductfrag;

    public PSubCategoryAdapter(Activity context, int[] img, String[] web) {

        super(context, R.layout.grid_row, web);
        this.context1 = context;
        this.web = web;
        this.img = img;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context1.getLayoutInflater();
        View view1= inflater.inflate(R.layout.grid_row, null, true);
        TextView txtTitle = (TextView) view1.findViewById(R.id.gridText);
        final ImageView imageView = (ImageView) view1.findViewById(R.id.gridimage);
        txtTitle.setText(web[position]);
        imageView.setImageResource(img[position]);

        Picasso.with(context1).load(img[position]).resize(100,100).into(imageView);


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                oneproductfrag = new OneProductFragment();

                Bundle bundle = new Bundle();
                int myPos = img[position];

                if(myPos == img[0]){
                    bundle.putInt("myProductPos",myPos);
                    oneproductfrag.setArguments(bundle);
                }

                else if(myPos == img[1]){

                    bundle.putInt("myProductPos",myPos);
                    oneproductfrag.setArguments(bundle);
                }
                else if(myPos == img[2]){
                    bundle.putInt("myProductPos",myPos);
                    oneproductfrag.setArguments(bundle);
                }
                Activity activityGrid = (Activity) context1;

                FragmentManager fragmentManager = activityGrid.getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.L_Layout,oneproductfrag);
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
            }
        });
        return view1;
    }
}
