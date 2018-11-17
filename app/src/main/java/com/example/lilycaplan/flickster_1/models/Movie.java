package com.example.lilycaplan.flickster_1.models;

import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilycaplan on 11/8/18.
 */


@Parcel
public class Movie {
    String posterPath;
    String title;
    String overview;
    String backdrop;
    double voteAverage;
    int movieId;

    //empty constructor for parceler

    public Movie(){

    }



    public Movie(JSONObject jsonObject) throws JSONException{
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdrop = jsonObject.getString("backdrop_path");
        voteAverage = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray)  throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for(int i=0; i< movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;

    }

    public String getBackdrop() {
        return String.format( "https://image.tmdb.org/t/p/w342/%s", backdrop);
    }

    public String getPosterPath() {
        return String.format( "https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() { return voteAverage;}

    public int getMovieId(){ return movieId;}
}
