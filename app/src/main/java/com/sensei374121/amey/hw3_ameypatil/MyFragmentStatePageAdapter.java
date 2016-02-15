package com.sensei374121.amey.hw3_ameypatil;


import android.graphics.Movie;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Amey on 09-02-2016.
 */
public class MyFragmentStatePageAdapter extends FragmentPagerAdapter {

    int count;
    public MyFragmentStatePageAdapter (FragmentManager fm, int size){
        super(fm);
        count=size;
    }

    MovieData movieData = new MovieData();
    @Override
    public Fragment getItem(int position) {
        return MovieData_Fragment.newInstance((HashMap<String,?>) movieData.getItem(position));
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        HashMap<String, ?> movie = (HashMap<String,?>)movieData.getItem(position);
        String name = (String)movie.get("name");
        return name.toUpperCase(l);
    }
}
