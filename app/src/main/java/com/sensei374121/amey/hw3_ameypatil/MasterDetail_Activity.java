package com.sensei374121.amey.hw3_ameypatil;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

public class MasterDetail_Activity extends AppCompatActivity implements List_Fragment.OnButtonListener{

    Fragment mContent;
    boolean areTwoPanes=false;
    HashMap<String,?> savemovieobj ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        if(findViewById(R.id.moviedata_layout)!=null){
            areTwoPanes=true;
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.masterdetail_container, List_Fragment.newInstance())
                    .commit();
        }else{
            if(areTwoPanes){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.moviedata_layout, MovieData_Fragment.newInstance((HashMap<String,?>) savedInstanceState.getSerializable("MOVIE_OBJ")))
                        .commit();
            }else{
               // mContent=getSupportFragmentManager().getFragment(savedInstanceState,"mContent");
                getSupportFragmentManager().beginTransaction()
                       .replace(R.id.masterdetail_container, MovieData_Fragment.newInstance((HashMap<String,?>) savedInstanceState.getSerializable("MOVIE_OBJ")))
                        //.replace(R.id.masterdetail_container,mContent)
                        .commit();
            }

        }
    }

    @Override
    public void ListButtonClicked(HashMap<String,?> movie_obj) {
        savemovieobj=movie_obj;
        if(areTwoPanes==false) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.masterdetail_container, MovieData_Fragment.newInstance(movie_obj))
                    .commit();
        }else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.moviedata_layout, MovieData_Fragment.newInstance(movie_obj))
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //code to save state.
       outState.putSerializable("MOVIE_OBJ",savemovieobj);
        //getSupportFragmentManager().putFragment(outState,"mContent",mContent);
    }
}
