package com.example.sony.MyMarket.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.sony.MyMarket.Adapter.PCategoryAdapter;
import com.example.sony.MyMarket.R;

/**
 * Created by Sony on 28-02-2017.
 */

public class PCategoryFragment extends Fragment {

    private GridView gridview;
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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.product_category_grid,container,false);
        gridview = (GridView)view.findViewById(R.id.gridview);

        PCategoryAdapter adapter1 = new PCategoryAdapter(getActivity(),img,web);
        gridview.setAdapter(adapter1);

        return view;
    }
}
