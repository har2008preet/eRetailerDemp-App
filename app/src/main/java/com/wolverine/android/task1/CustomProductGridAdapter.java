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

/**
 * Created by Android on 02-11-2015.
 */
public class CustomProductGridAdapter extends BaseAdapter {
    private Activity activity;
    private Context context;
    String[] discount;
    String[] product_title;
    String[] discount_price;
    String[] actual_price;
    int[] image;

    private static LayoutInflater inflater=null;

    public CustomProductGridAdapter(Context context,String[] Discount,String[] title,String[] d_price,String[] a_price,int[] Image){
        this.context = context;
        discount = Discount;
        product_title = title;
        discount_price = d_price;
        actual_price = a_price;
        image = Image;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return product_title.length;
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
        TextView discount;
        TextView title;
        TextView dis_price;
        TextView act_price;
        ImageView img;
    }

    @Override
    public View getView(int position, View rowView, ViewGroup parent) {
        Holder holder = new Holder();

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (rowView == null)
            rowView = inflater.inflate(R.layout.custom_product_gridlist, null);

        holder.discount = (TextView) rowView.findViewById(R.id.discount_tag);
        holder.title = (TextView) rowView.findViewById(R.id.product_title);
        holder.dis_price = (TextView) rowView.findViewById(R.id.discounted_price);
        holder.act_price = (TextView) rowView.findViewById(R.id.actual_price);
        holder.img = (ImageView) rowView.findViewById(R.id.grid_imageview);

        holder.discount.setText(discount[position]);
        holder.title.setText(product_title[position]);
        holder.dis_price.setText(discount_price[position]);
        holder.act_price.setText(actual_price[position]);
        Log.d("String2", holder.title.getText().toString());
        holder.img.setImageResource(image[position]);
        return rowView;
    }
}
