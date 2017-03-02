package com.example.sony.loginscreensimple;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Sony on 28-02-2017.
 */

public class OneProductFragment extends Fragment{

    ListView myList;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_product_list,container,false);

        myList = (ListView)view.findViewById(R.id.one_product_display_list);

        int retrivePosition = getArguments().getInt("myProductPos");

//            PSubVegAdapter adapter1 = new PSubVegAdapter(getActivity(), imgveg, webveg, context1, inflater, myvegpojo, webveg1);
//            myList.setAdapter(adapter1);

        return view;
    }
}
