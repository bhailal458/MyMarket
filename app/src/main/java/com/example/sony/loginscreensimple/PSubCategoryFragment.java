package com.example.sony.loginscreensimple;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Sony on 28-02-2017.
 */

public class PSubCategoryFragment extends Fragment {

    private GridView gridview;
    private int retrivePosition;

    private int img[] = {
            R.drawable.veg,
            R.drawable.fruits,
            R.drawable.grains,
    };
    private String[] web = {
            "Vegetables",
            "Fruits",
            "Grains",
    } ;

    private int imgveg[] = {
            R.drawable.vegpotato,
            R.drawable.vegbrinjal,
            R.drawable.vegtomato,
            R.drawable.vegbittergourd,
            R.drawable.vegcabbage,
            R.drawable.vegcerrot,
            R.drawable.vegladyfinger,
            R.drawable.vegpeas,
    };
    private String[] webveg = {
            "Potato",
            "brinjal",
            "Tomato",
            "Bitter gourd",
            "Cabbage",
            "Carrot",
            "Lady Finger",
            "Peas",
    } ;
    private int imgfruits[] = {
            R.drawable.fmango,
            R.drawable.fapple,
            R.drawable.fpineapple,
            R.drawable.fkiwi,
            R.drawable.fstrawberry,
            R.drawable.forange,
            R.drawable.fbanana,
            R.drawable.fwatermelon,
    };
    private String[] webfruits = {
            "Mango",
            "Apple",
            "Pineapple",
            "Kiwi",
            "Strawberry",
            "Orange",
            "Banana",
            "Watermelon",
    } ;

    private int imggrains[] = {
            R.drawable.gchickpeas,
            R.drawable.gcorn,
            R.drawable.gcouscous,
            R.drawable.ggreenlentils,
            R.drawable.gredkidneybeans,
            R.drawable.grice,
            R.drawable.gwheat,
            R.drawable.gsplitredlentil,
    };
    private String[] webgrains = {
            "Chick peas",
            "Corn",
            "Couscous",
            "Green lentils",
            "Red kidney beans",
            "Rice",
            "Wheat",
            "Split Red lentil",
    } ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.product_category_grid,container,false);
        gridview = (GridView)view.findViewById(R.id.gridview);
        retrivePosition = getArguments().getInt("myProductPos");

        if (retrivePosition == img[0]) {

            ArrayList<PojoVeg> myveg = new ArrayList<>();
            for (int i = 0; i <imgveg.length ; i++) {
                PojoVeg pojoveg = new PojoVeg();
                pojoveg.setImgveg(imgveg[i]);
                pojoveg.setWebveg(webveg[i]);
                myveg.add(pojoveg);
            }
            PSubVegAdapter adapterveg = new PSubVegAdapter(getActivity(),myveg);
            gridview.setAdapter(adapterveg);
        }

        if(retrivePosition ==img[1]){

            ArrayList<PojoFruits> myfruits = new ArrayList<>();
            for (int i = 0; i <imgfruits.length ; i++) {
                PojoFruits pojofruits = new PojoFruits();
                pojofruits.setImgfruits(imgfruits[i]);
                pojofruits.setWebfruits(webfruits[i]);
                myfruits.add(pojofruits);
            }
            PSubFruitsAdapter adapterfruits = new PSubFruitsAdapter(getActivity(),myfruits);
            gridview.setAdapter(adapterfruits);

        }

        if(retrivePosition == img[2]){
            ArrayList<PojoGrains> mygrains = new ArrayList<>();
            for (int i = 0; i <imggrains.length ; i++) {
                PojoGrains pojoGrains = new PojoGrains();
                pojoGrains.setImggrains(imggrains[i]);
                pojoGrains.setWebgrains(webgrains[i]);
                mygrains.add(pojoGrains);
            }
            PSubGrainsAdapter adaptergrains = new PSubGrainsAdapter(getActivity(),mygrains);
            gridview.setAdapter(adaptergrains);

        }
        return view;
    }

}
