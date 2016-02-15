package com.sensei374121.amey.hw3_ameypatil;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewPager_Activity extends AppCompatActivity {

    MovieData moviedata = new MovieData();
    ViewPager mViewpager;
    MyFragmentStatePageAdapter mypageadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mypageadapter = new MyFragmentStatePageAdapter(getSupportFragmentManager(),moviedata.getSize());
        mViewpager = (ViewPager)findViewById(R.id.viewpager);
        mViewpager.setAdapter(mypageadapter);
        mViewpager.setCurrentItem(3);

        TabLayout tablayout = (TabLayout)findViewById(R.id.tab_layout);
        tablayout.setupWithViewPager(mViewpager);

        mViewpager.setPageTransformer(false, new ViewPager.PageTransformer(){
            @Override
            public void transformPage(View page, float position) {
                page.setRotationY(position*-30);
            }
        });


    }




}
