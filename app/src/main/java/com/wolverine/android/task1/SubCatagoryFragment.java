package com.wolverine.android.task1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Android on 27-10-2015.
 */
public class SubCatagoryFragment extends Fragment {
    private NavigationDrawerFragment mNavigationDrawerFragment;

    public static SubCatagoryFragment newInstance() {
        SubCatagoryFragment fragment = new SubCatagoryFragment();
        return fragment;
    }
    public SubCatagoryFragment(){
    }

    private Integer images[] = {R.drawable.belt1_men, R.drawable.belt2_men, R.drawable.jacket_men,R.drawable.jacket2_men,R.drawable.deo_men};
    ListView lv;
    Context context;

    public static int [] pics= {R.drawable.clothing_men,R.drawable.shoe_men,
            R.drawable.bag_men,R.drawable.watch_men};

    public static String [] sub_catagory = {"Clothing","Shoes","Bags","Watches"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_men, container,
                false);
        setHasOptionsMenu(true);
        Toast.makeText(getActivity().getApplicationContext(), "Select 'Shoes' in 'Catagories'", Toast.LENGTH_SHORT).show();
        lv=(ListView) rootView.findViewById(R.id.cata_men);
        lv.setAdapter(new CustomSubCatagoryAdapter(getActivity().getApplicationContext(), sub_catagory, pics));
        addImagesToThegallery(rootView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    Intent i = new Intent(getActivity().getApplication(),TypeofSubCat.class);
                    startActivity(i);
                }
            }
        });

        return rootView;
    }
    public void restoreActionBar () {
        ActionBar actionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Men");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addImagesToThegallery(View rootView) {
        LinearLayout imageGallery = (LinearLayout) rootView.findViewById(R.id.pop_pro_men);
        for (Integer image : images) {
            imageGallery.addView(getImageView(image));
        }
    }

    private View getImageView(Integer image) {
        ImageView imageView = new ImageView(getActivity().getApplicationContext());
        imageView.setImageResource(image);
        imageView.setAdjustViewBounds(true);
        return imageView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(2);
    }
}
