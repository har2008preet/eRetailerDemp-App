package com.wolverine.android.task1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductsOfCatagories extends MainActivity {
    GridView gridView;
    public static String[] Discounts = {"-50%","-50%","-69%","-64%"};
    public static String[] Title = {"Shoe Mate Black formal (sm-291) Lace Up Shoes","Shoe Mate sm283 Lace Up Shoes"
            ,"Wonker GAN-13 Slip-On Shoes","Krassa High Ankle Lace Up Shoes"};
    public static String[] d_price = {"499","499","299","499"};
    public static String[] a_price = {"999","999","799","1400"};
    public static int [] pics= {R.drawable.firstshoe_firstimage,R.drawable.secondshoe_firstimage,
            R.drawable.thirdshoe_firstimage,R.drawable.fourthshoe_firstimage};
    public static String[] Brand = {"Shoe Mate","Shoe Mate"
            ,"Wonker","Krassa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_products_of_catagories);
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);        //---|
                                                                                                                 //   |
        View contentView = inflater.inflate(R.layout.activity_products_of_catagories,null,false);                //   |---for navigation drawer
        mDrawerLayout.addView(contentView, 1);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        mTitle= "Men's Formal Shoes";

        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new CustomProductGridAdapter(this, Discounts,Title,d_price,a_price,pics));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent i = new Intent(getApplicationContext(),ProductDetail.class);
                i.putExtra("Discount",Discounts[position]);
                i.putExtra("Title",Title[position]);
                i.putExtra("d_price",d_price[position]);
                i.putExtra("a_price",a_price[position]);
                i.putExtra("pics",pics[position]);
                i.putExtra("Brand",Brand[position]);
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_products_of_catagories, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
