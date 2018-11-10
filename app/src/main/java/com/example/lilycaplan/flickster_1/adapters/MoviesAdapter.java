package com.example.lilycaplan.flickster_1.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lilycaplan.flickster_1.R;
import com.example.lilycaplan.flickster_1.models.Movie;

import java.util.List;

/**
 * Created by lilycaplan on 11/8/18.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    Context context;
    List<Movie> movies;

    public  MoviesAdapter(Context context, List<Movie> movies){
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvOverView;
        ImageView ivPoster;
        int orientation;

        public ViewHolder(View itemView){
            super(itemView);

            orientation = context.getResources().getConfiguration().orientation;

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverView = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);


        }

        public void bind(Movie movie){
            tvTitle.setText(movie.getTitle());
            tvOverView.setText(movie.getOverview());

            String imgPath;

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                imgPath = movie.getBackdrop();
            } else {
                imgPath = movie.getPosterPath();
            }

            Glide.with(context).load(imgPath).into(ivPoster);
        }
    }

}
