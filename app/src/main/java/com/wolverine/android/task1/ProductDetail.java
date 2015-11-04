package com.wolverine.android.task1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

public class ProductDetail extends MainActivity {
    PagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    TextView Title,Discounted_price,Actual_price,Brand;
    ImageView b1,b2,b3,b4,la,ra;

    String discount,title,a_price,d_price,brand;
    int pic;
    PageListener pageListener;
    android.support.v7.widget.ShareActionProvider mShareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_product_detail);*/
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);        //---|
                                                                                                                 //   |
        View contentView = inflater.inflate(R.layout.activity_product_detail,null,false);                        //   |---for navigation drawer
        mDrawerLayout.addView(contentView, 1);

        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        Title = (TextView)findViewById(R.id.title);
        Discounted_price = (TextView)findViewById(R.id.discounted_price);
        Actual_price = (TextView)findViewById(R.id.actual_price);
        Brand = (TextView)findViewById(R.id.company);

        b1 = (ImageView)findViewById(R.id.scroll1);
        b2 = (ImageView)findViewById(R.id.scroll2);
        b3 = (ImageView)findViewById(R.id.scroll3);
        b4 = (ImageView)findViewById(R.id.scroll4);
        la = (ImageView)findViewById(R.id.left_arrow);
        ra = (ImageView)findViewById(R.id.right_arrow);
        int[] mResources1 = {
                R.drawable.firstshoe_firstimage,
                R.drawable.firstshoe_secondimage,
                R.drawable.firstshoe_thirdimage,
                R.drawable.firstshoe_fourthimage
        };
        int[] mResources2 = {
                R.drawable.secondshoe_firstimage,
                R.drawable.secondshoe_secondimage,
                R.drawable.secondshoe_thirdimage,
                R.drawable.secondshoe_fourthimage
        };
        int[] mResources3 = {
                R.drawable.thirdshoe_firstimage,
                R.drawable.thirdshoe_secondimage,
                R.drawable.thirdshoe_thirdimage,
                R.drawable.thirdshoe_fourthimage
        };
        int[] mResources4 = {
                R.drawable.fourthshoe_firstimage,
                R.drawable.fourthshoe_secondmage,
                R.drawable.fourthshoe_thirdimage,
                R.drawable.fourthshoe_fourthimage
        };
        mCustomPagerAdapter = new CustomPagerAdapter(this,mResources1);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        Intent intent = getIntent();
        discount = intent.getStringExtra("Discount");
        title = intent.getStringExtra("Title");
        a_price = intent.getStringExtra("a_price");
        d_price = intent.getStringExtra("d_price");
        pic = intent.getIntExtra("pics", 0);
        brand = intent.getStringExtra("Brand");

        if(title.matches("Shoe Mate Black formal (sm-291) Lace Up Shoes")){
            mCustomPagerAdapter = new CustomPagerAdapter(this,mResources1);

            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);
            Title.setText(title);
            Discounted_price.setText(d_price);
            Actual_price.setText(a_price);
            Brand.setText(brand);
        }
        else if(title.matches("Shoe Mate sm283 Lace Up Shoes")){
            mCustomPagerAdapter = new CustomPagerAdapter(this,mResources2);

            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);
            Title.setText(title);
            Discounted_price.setText(d_price);
            Actual_price.setText(a_price);
            Brand.setText(brand);
        }
        else if(title.matches("Wonker GAN-13 Slip-On Shoes")){
            mCustomPagerAdapter = new CustomPagerAdapter(this,mResources3);

            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);
            Title.setText(title);
            Discounted_price.setText(d_price);
            Actual_price.setText(a_price);
            Brand.setText(brand);
        }
        else if(title.matches("Krassa High Ankle Lace Up Shoes")){
            mCustomPagerAdapter = new CustomPagerAdapter(this,mResources4);

            mViewPager = (ViewPager) findViewById(R.id.pager);
            mViewPager.setAdapter(mCustomPagerAdapter);
            Title.setText(title);
            Discounted_price.setText(d_price);
            Actual_price.setText(a_price);
            Brand.setText(brand);
        }
        pageListener = new PageListener();
        mViewPager.setOnPageChangeListener(pageListener);



    }
    private int currentPage;
    private class PageListener extends ViewPager.SimpleOnPageChangeListener {
        public void onPageSelected(int position) {
            Log.i("Position====", "page selected " + position);
            currentPage = position;
            if(position==0){
                b1.setImageResource(R.drawable.toggle_on);
                b2.setImageResource(R.drawable.toggle_off);
                b3.setImageResource(R.drawable.toggle_off);
                b4.setImageResource(R.drawable.toggle_off);
                la.setImageResource(R.drawable.left_arrow_light);
                ra.setImageResource(R.drawable.right_arrow_dark);
            }
            if(position==1){
                b2.setImageResource(R.drawable.toggle_on);
                b1.setImageResource(R.drawable.toggle_off);
                b3.setImageResource(R.drawable.toggle_off);
                b4.setImageResource(R.drawable.toggle_off);
                la.setImageResource(R.drawable.left_arrow_dark);
                ra.setImageResource(R.drawable.right_arrow_dark);
            }
            if(position==2){
                b3.setImageResource(R.drawable.toggle_on);
                b1.setImageResource(R.drawable.toggle_off);
                b2.setImageResource(R.drawable.toggle_off);
                b4.setImageResource(R.drawable.toggle_off);
                la.setImageResource(R.drawable.left_arrow_dark);
                ra.setImageResource(R.drawable.right_arrow_dark);
            }
            if(position==3){
                b4.setImageResource(R.drawable.toggle_on);
                b1.setImageResource(R.drawable.toggle_off);
                b2.setImageResource(R.drawable.toggle_off);
                b3.setImageResource(R.drawable.toggle_off);
                la.setImageResource(R.drawable.left_arrow_dark);
                ra.setImageResource(R.drawable.right_arrow_light);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_detail, menu);
        MenuItem item = menu.findItem(R.id.share);
        mShareActionProvider= (android.support.v7.widget.ShareActionProvider) MenuItemCompat.getActionProvider(item);
        String msg = "Check this product";
        Intent shareIntent = ShareCompat.IntentBuilder.from(this).setType("text/plain").setText(msg).getIntent();
        mShareActionProvider.setShareIntent(shareIntent);
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
