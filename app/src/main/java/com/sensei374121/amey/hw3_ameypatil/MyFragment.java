package com.sensei374121.amey.hw3_ameypatil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Amey on 09-02-2016.
 */
public class MyFragment extends Fragment {

    private static final String FRAGMENT_ID="fragment_id";

    public static MyFragment newInstance(int fragment_id){
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();

        //code to add any values
        args.putInt(FRAGMENT_ID,fragment_id);

        fragment.setArguments(args);
        return fragment;
    }

    public MyFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //get interface object
        final buttonListener_Interface interface_obj;

        //point the object to the activity that is implementing the interface.
        interface_obj = (buttonListener_Interface)getContext();

        View rootView = null;
        int choice = getArguments().getInt(FRAGMENT_ID);
        switch (choice){
            case R.id.home_fragment:
                rootView = inflater.inflate(R.layout.home_fragment, container, false);
                break;
            case R.id.aboutme_fragment:
                rootView = inflater.inflate(R.layout.aboutme_fragment, container, false);
                break;

        }
        //Creating the button reference
      //  rootView = inflater.inflate(R.layout.home_fragment, container, false);
        Button btn_aboutme = (Button) rootView.findViewById(R.id.button_about_me);
        Button btn_task2 = (Button) rootView.findViewById(R.id.button_task2);
        Button btn_task3 = (Button) rootView.findViewById(R.id.button_task3);

        //Setting up the about me onClickListener
        if (btn_aboutme != null) {
            btn_aboutme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interface_obj.aboutMeButtonListen();
                }
            });
        }
        //setting up the task2 onClickListener
        if(btn_task2 != null){
            btn_task2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interface_obj.task2ButtonListen();
                }
            });
        }
        //setting up the task3 onClickListener
        if(btn_task3 != null){
            btn_task3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interface_obj.task3ButtonListen();
                }
            });
        }

        return rootView;
    }

    public interface buttonListener_Interface{
        void aboutMeButtonListen();
        void task2ButtonListen();
        void task3ButtonListen();
    }



}