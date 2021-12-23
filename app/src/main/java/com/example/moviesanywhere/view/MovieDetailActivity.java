package com.example.moviesanywhere.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviesanywhere.R;
import com.example.moviesanywhere.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    private TextView overviewView, voteAverageDetailView, popularityDetailView, dateDetail;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        overviewView = findViewById(R.id.overviewDetail);
        imageView = findViewById(R.id.imageDetail);
        voteAverageDetailView = findViewById(R.id.voteAverageDetail);
        popularityDetailView = findViewById(R.id.popularityDetail);
        dateDetail = findViewById(R.id.dateDetail);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");
        setTitle(movie.getTitle());

        overviewView.setText(movie.getOverview());
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w400" + movie.getPoster_path())
                .into(imageView);

        voteAverageDetailView.setText(Float.toString(movie.getVote_average()));
        popularityDetailView.setText(Float.toString(movie.getPopularity()));
        dateDetail.setText(movie.getRelease_date());


    }
}