package com.example.sony.loginscreensimple;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

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
            "Cerrot",
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
            PSubCategoryAdapter adapter1 = new PSubCategoryAdapter(getActivity(), imgveg, webveg);
            gridview.setAdapter(adapter1);
        }

        if(retrivePosition ==img[1]){
            PSubCategoryAdapter adapter1 = new PSubCategoryAdapter(getActivity(), imgfruits, webfruits);
            gridview.setAdapter(adapter1);

        }
        if(retrivePosition == img[2]){
            PSubCategoryAdapter adapter1 = new PSubCategoryAdapter(getActivity(), imggrains, webgrains);
            gridview.setAdapter(adapter1);

        }
        return view;
    }

}
