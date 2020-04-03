package com.bec.bapatla.college;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;
public class gallery extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        List<DataObject> getData = dataSource();
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        CustomPageAdapter mCustomPagerAdapter = new CustomPageAdapter(gallery.this, getData);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(mCustomPagerAdapter);
    }
    private List<DataObject> dataSource(){
        List<DataObject> data = new ArrayList<DataObject>();
        data.add(new DataObject(R.drawable.geb, "General Engineering Block"));
        data.add(new DataObject(R.drawable.lib, "admin block"));
        data.add(new DataObject(R.drawable.rp, "Research Park"));
        data.add(new DataObject(R.drawable.cmb, "Civil And Mechanical Block"));
        data.add(new DataObject(R.drawable.main, "Main Building"));
        data.add(new DataObject(R.drawable.faculty, ""));
        data.add(new DataObject(R.drawable.chemical, "Chemical Block"));
        data.add(new DataObject(R.drawable.bect, "During Bectagon2K16"));
        data.add(new DataObject(R.drawable.bect1, "During Bectagon2K16"));
        return data;
    }
}
