package com.example.moviesanywhere.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesanywhere.R;
import com.example.moviesanywhere.model.Movie;
import com.example.moviesanywhere.view.MovieDetailActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {


    private final Context ctx;
    ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context ctx, ArrayList<Movie> movieArrayList) {
        this.ctx = ctx;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        holder.bindData(movie);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView imgViewCover;
        private final TextView movieTitle;
        private final TextView movieDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imgViewCover = itemView.findViewById(R.id.imgViewCover);
            movieTitle = itemView.findViewById(R.id.movieTitle);
            movieDescription = itemView.findViewById(R.id.movieDescription);

            itemView.setOnClickListener(this);
        }

        public void bindData(Movie movie) {
            movieTitle.setText(movie.getTitle());
            movieDescription.setText(movie.getOverview());
            Glide.with(ctx)
                    .load("https://image.tmdb.org/t/p/w400" + movie.getBackdrop_path())
                    .into(imgViewCover);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ctx, MovieDetailActivity.class);
            intent.putExtra("movie", movieArrayList.get(getAdapterPosition()));
            ctx.startActivity(intent);
        }
    }
}
