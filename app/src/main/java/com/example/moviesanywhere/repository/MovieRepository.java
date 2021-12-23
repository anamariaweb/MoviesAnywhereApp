package com.example.moviesanywhere.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviesanywhere.response.MovieResponse;
import com.example.moviesanywhere.retrofit.ApiRequest;
import com.example.moviesanywhere.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static final String TAG = MovieRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public MovieRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<MovieResponse> getMovies(String language, String apiKey) {
        final MutableLiveData<MovieResponse> data = new MutableLiveData<>();
        apiRequest.getMovies(language, apiKey)
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        Log.d(TAG, "onReponse response: " + response);

                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        data.setValue(null);
                        Log.d(TAG, "onReponse error: " + t.getMessage());
                    }
                });

        return data;
    }
}
