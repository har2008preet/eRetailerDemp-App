package com.wolverine.android.task1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Android on 27-10-2015.
 */
public class CatagoriesFragment extends Fragment{

    public static CatagoriesFragment newInstance() {
        CatagoriesFragment fragment = new CatagoriesFragment();
        return fragment;
    }
    public CatagoriesFragment(){
    }

    ListView lv;
    Context context;

    public static int [] images = {R.drawable.men_clothing_catagory,R.drawable.women_clothing_catagory,
            R.drawable.kids_clothing_catagory,R.drawable.beauty_catagory,R.drawable.sale_catagory,R.drawable.furnishing_catagory,
            R.drawable.kitchenware_catagory,R.drawable.furniture_catagory};

    public static String [] catagory = {"Men","Women","Kids & Babies","Beauty","Sale","Home Furnishing","Kitchenware","Furniture"};
    public static String [] description = {"Clothing, Shoes, Bags, Watches","Clothing, Shoes, Bags, Jewellery & Watches",
            "Girls, Boys, Toys, Sale","Beauty, Appliances, Makeup, Skin Care",
            "Men, Women, Kids, Baby","Bath, Home Decor, Home Textile, Sale",
            "Glassware, Tableware, Coffee, Mugs, Sale","Bean Bags, Shelves, Sofas, Wardrobes, Stools"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_catagories, container,
                false);

        context = getActivity().getBaseContext();
        lv=(ListView) rootView.findViewById(R.id.list_cata);
        lv.setAdapter(new CustomCatagoryAdapter(getActivity().getApplicationContext(), catagory, description , images));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Fragment newFragment = new SubCatagoryFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(1);
    }
}
