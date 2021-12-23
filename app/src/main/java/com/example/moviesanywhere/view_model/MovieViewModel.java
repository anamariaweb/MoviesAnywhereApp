package com.example.moviesanywhere.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.moviesanywhere.repository.MovieRepository;
import com.example.moviesanywhere.response.MovieResponse;
import com.example.moviesanywhere.retrofit.ApiRequest;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;
    private LiveData<MovieResponse> movieResponseLiveData;

    public MovieViewModel(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository();
        this.movieResponseLiveData = movieRepository.getMovies("en-US", ApiRequest.API_KEY);
    }

    public LiveData<MovieResponse> getMovieResponseLiveData() {
        return movieResponseLiveData;
    }
}
