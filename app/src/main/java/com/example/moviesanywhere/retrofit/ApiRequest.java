package com.example.moviesanywhere.retrofit;

import com.example.moviesanywhere.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    /**
     * Please insert your api key here.
     */
    String API_KEY = "";

    @GET("3/movie/popular")
    Call<MovieResponse> getMovies(
            @Query("language") String language,
            @Query("api_key") String apiKey
    );
}
