package com.sensei374121.amey.hw3_ameypatil;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Amey on 09-02-2016.
 */
public class MovieData_Fragment extends Fragment {

    //Initializing the movie data object.
    MovieData moviedata_obj= new MovieData();
    static HashMap<String, ?>  movie;

    public MovieData_Fragment(){

    }
    public static MovieData_Fragment newInstance(HashMap<String, ?> inputmovie){
        MovieData_Fragment obj = new MovieData_Fragment();
        Bundle outState = new Bundle();
        outState.putSerializable("MOVIE_OBJ",inputmovie);
        obj.setArguments(outState);
        movie=inputmovie;
        return obj;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.moviedata_layout,container,false);

        //movie = (HashMap<String,?>)moviedata_obj.getItem(1);
        movie = (HashMap<String,?>)getArguments().getSerializable("MOVIE_OBJ");

        //TextView title = (TextView)rootView.findViewById(R.id.movie_title);
        TextView movie_director = (TextView)rootView.findViewById(R.id.movie_director);
        TextView movie_length = (TextView)rootView.findViewById(R.id.movie_length);
        TextView movie_description = (TextView)rootView.findViewById(R.id.movie_description);
        ImageView movie_image = (ImageView)rootView.findViewById(R.id.movie_image);
        RatingBar movie_rating = (RatingBar) rootView.findViewById(R.id.movie_rating);
        TextView movie_stars = (TextView)rootView.findViewById(R.id.movie_stars);
        TextView movie_url = (TextView)rootView.findViewById(R.id.movie_url);
        TextView movie_year = (TextView)rootView.findViewById(R.id.movie_year);

        if( movie_year!=null && movie_stars!= null && movie_url!= null && movie_description != null && movie_director != null && movie_length != null && movie_image != null && movie_rating != null){
           // title.setText((String) movie.get("name"));
            movie_director.setText((String) movie.get("director"));
            movie_stars.setText((String) movie.get("stars"));
            movie_url.setText((String) movie.get("url"));
            movie_year.setText((String) movie.get("year"));
            movie_description.setText((String) movie.get("description"));
            movie_length.setText((String) movie.get("length"));
            movie_image.setImageResource((Integer) movie.get("image"));
            double rating_d = (Double)movie.get("rating")/2;
           // float rating_f = (float) rating_d;
            movie_rating.setRating((float) rating_d);
            //to give different colors for rating bar
            Drawable drawable = movie_rating.getProgressDrawable();
            drawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);

        }





        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //saving the movie object
        outState.putSerializable("MOVIE_OBJ",movie);
    }
}
