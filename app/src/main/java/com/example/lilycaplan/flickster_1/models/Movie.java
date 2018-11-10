package com.example.lilycaplan.flickster_1.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilycaplan on 11/8/18.
 */

public class Movie {
    String posterPath;
    String title;
    String overview;
    String backdrop;


    public Movie(JSONObject jsonObject) throws JSONException{
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdrop = jsonObject.getString("backdrop_path");
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
}
