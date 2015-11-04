package com.wolverine.android.task1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Android on 26-10-2015.
 */
public class CustomCatagoryAdapter extends BaseAdapter {
    private Activity activity;
    String[] catagory;
    String[] catagory_desc;
    int[] image;
    Context context;

    private static LayoutInflater inflater=null;

    public CustomCatagoryAdapter(Context mainActivity, String[] Catagory, String[] Catagory_desc, int[] Image){
        catagory = Catagory;
        catagory_desc = Catagory_desc;
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
        TextView cata_name;
        TextView cata_desc;
        ImageView img;
    }

    @Override
    public View getView(final int position, View rowView, ViewGroup parent) {
        Holder holder = new Holder();
        View textView;

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (rowView == null)
            rowView = inflater.inflate(R.layout.custom_catagory_list, null);

        textView = rowView.findViewById(R.id.relativeLayout);

        holder.cata_name = (TextView) rowView.findViewById(R.id.catagory_name);
        holder.cata_desc = (TextView) rowView.findViewById(R.id.catagory_desc);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);

        holder.cata_name.setText(catagory[position]);
        holder.cata_desc.setText(catagory_desc[position]);
        Log.d("String2", holder.cata_name.getText().toString());
        holder.img.setImageResource(image[position]);

        if(position==0){
            textView.setBackgroundColor(Color.parseColor("#289FA5"));
        }
        if(position==1){
            textView.setBackgroundColor(Color.parseColor("#E93165"));
        }
        if(position==2){
            textView.setBackgroundColor(Color.parseColor("#9FBE3C"));
        }
        if(position==3){
            textView.setBackgroundColor(Color.parseColor("#F8AC1B"));
        }
        if(position==4){
            textView.setBackgroundColor(Color.parseColor("#6B294F"));
        }
        if(position==5){
            textView.setBackgroundColor(Color.parseColor("#289FA5"));
        }
        if(position==6){
            textView.setBackgroundColor(Color.parseColor("#E93165"));
        }
        if(position==7){
            textView.setBackgroundColor(Color.parseColor("#9FBE3C"));
        }

        return rowView;
    }
}
