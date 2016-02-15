package com.sensei374121.amey.hw3_ameypatil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashMap;

/**
 * Created by Amey on 09-02-2016.
 */
public class List_Fragment extends Fragment{

    MovieData movie_data = new MovieData();
    HashMap<String,?> movie;

    public static List_Fragment newInstance(){
        List_Fragment obj = new List_Fragment();
        return obj;
    }
    public List_Fragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        //Initializing the views
        View rootview = inflater.inflate(R.layout.listfragment_layout,container,false);

        //Interface object declaration and type casting to activity that implements it.
        final OnButtonListener int_obj;
        int_obj = (OnButtonListener) getContext();

        //Creating button ids
        Button bt1 = (Button)rootview.findViewById(R.id.b1);
        Button bt2 = (Button)rootview.findViewById(R.id.b2);
        Button bt3 = (Button) rootview.findViewById(R.id.b3);
        Button bt4 = (Button) rootview.findViewById(R.id.b4);
        Button bt5 = (Button) rootview.findViewById(R.id.b5);

        if(bt1!=null && bt2!=null && bt3!=null && bt4!=null && bt5!=null ){
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movie = (HashMap)movie_data.getItem(1);
                    int_obj.ListButtonClicked(movie_data.getItem(1));
                }
            });
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int_obj.ListButtonClicked(movie_data.getItem(2));
                }
            });
            bt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int_obj.ListButtonClicked(movie_data.getItem(3));
                }
            });
            bt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int_obj.ListButtonClicked(movie_data.getItem(4));
                }
            });
            bt5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int_obj.ListButtonClicked(movie_data.getItem(7));
                }
            });
        }


        return rootview;
    }

    public interface OnButtonListener{
        void ListButtonClicked(HashMap<String,?> movie_obj);
    }
}
