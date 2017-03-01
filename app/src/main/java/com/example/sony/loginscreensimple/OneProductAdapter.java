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

public class OneProductAdapter extends ArrayAdapter<String> {


    private Activity context1;
    private LayoutInflater inflater;
    private int[] img;
    private final String[] web;
    private PSubCategoryFragment psubfrag;

    public OneProductAdapter(Activity context, int[] img, String[] web) {

        super(context, R.layout.product_row, web);
        this.context1 = context;
        this.web = web;
        this.img = img;
    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context1.getLayoutInflater();
        View view1= inflater.inflate(R.layout.product_row, null, true);
        TextView txtTitle = (TextView) view1.findViewById(R.id.product_text);
        final ImageView imageView = (ImageView) view1.findViewById(R.id.product_image);

        txtTitle.setText(web[position]);
        imageView.setImageResource(img[position]);

        Picasso.with(context1).load(img[position]).resize(100,100).into(imageView);

        return view1;
    }


}
