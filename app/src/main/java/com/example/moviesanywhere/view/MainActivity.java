package com.example.moviesanywhere.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.moviesanywhere.R;
import com.example.moviesanywhere.adapter.MovieAdapter;
import com.example.moviesanywhere.model.Movie;
import com.example.moviesanywhere.view_model.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress_circular_movie ;
    private MovieAdapter movieAdapter;
    private final ArrayList<Movie> movieArrayList = new ArrayList<>();
    MovieViewModel movieViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        getMovies();
    }

    private void initialization() {
        progress_circular_movie = findViewById(R.id.progress_circular_movie);
        RecyclerView my_recycler_view = findViewById(R.id.recyclerView);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        movieAdapter = new MovieAdapter(this, movieArrayList);
        my_recycler_view.setAdapter(movieAdapter);

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
    }

    private void getMovies() {
        movieViewModel.getMovieResponseLiveData().observe(this, movieResponse -> {
            if (movieResponse != null) {

                progress_circular_movie.setVisibility(View.GONE);
                List<Movie> movies = movieResponse.getMovies();
                movieArrayList.addAll(movies);
                movieAdapter.notifyDataSetChanged();
            }
        });
    }
}