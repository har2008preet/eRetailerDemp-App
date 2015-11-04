package com.wolverine.android.task1;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Android on 27-10-2015.
 */
public class CustomSubCatagoryAdapter extends BaseAdapter {
    private Activity activity;
    String[] catagory;
    int[] image;
    Context context;

    private static LayoutInflater inflater=null;

    public CustomSubCatagoryAdapter(Context mainActivity, String[] Catagory, int[] Image){
        catagory = Catagory;
        image = Image;
        context = mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return catagory.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView sub_cata;
        ImageView img;
    }

    @Override
    public View getView(final int position, View rowView, ViewGroup parent) {
        final Holder holder = new Holder();

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        rowView = inflater.inflate(R.layout.custom_subcatagory_list, null,true);

        TextView sub_catagory= (TextView) rowView.findViewById(R.id.cata_name);
        ImageView pic = (ImageView) rowView.findViewById(R.id.imageView2);

        sub_catagory.setText(catagory[position]);
        pic.setImageResource(image[position]);
        Log.d("Strings========", sub_catagory.getText().toString());


        return rowView;
    }
}
