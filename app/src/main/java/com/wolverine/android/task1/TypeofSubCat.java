package com.wolverine.android.task1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TypeofSubCat extends MainActivity {
    ListView lv;
    public static int [] pics= {R.drawable.men_slipper,R.drawable.men_mocasines,
            R.drawable.men_formal,R.drawable.men_loafers,R.drawable.men_boots,R.drawable.men_sports};

    public static String [] sub_catagory = {"Slippers","Moccasines","Formal Shoes","Loafers","Boots","Sport Shoes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_typeof_sub_cat);*/
        /*super.replaceContentLayout(R.layout.activity_typeof_sub_cat,R.id.container);*/
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//---|
                                                                                                         //   |
        View contentView = inflater.inflate(R.layout.activity_typeof_sub_cat,null,false);                //   |---for navigation drawer
        mDrawerLayout.addView(contentView,1);                                                            //---|   with this activity

        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        Toast.makeText(TypeofSubCat.this, "Select 'Formal Shoes'", Toast.LENGTH_SHORT).show();
        
        lv=(ListView) findViewById(R.id.type_of_Sub);
        lv.setAdapter(new CustomSubCatagoryAdapter(this, sub_catagory, pics));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==2){
                    startActivity(new Intent(getApplication(),ProductsOfCatagories.class));
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_typeof_sub_cat, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
