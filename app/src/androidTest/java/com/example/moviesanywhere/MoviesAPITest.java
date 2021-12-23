package com.example.moviesanywhere;

import static org.junit.Assert.assertTrue;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.moviesanywhere.response.MovieResponse;
import com.example.moviesanywhere.retrofit.ApiRequest;
import com.example.moviesanywhere.retrofit.RetrofitRequest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

@RunWith(AndroidJUnit4.class)
public class MoviesAPITest {

    @Test
    public void callMoviesEndpoint() throws IOException {
        ApiRequest apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
        Call<MovieResponse> call = apiRequest.getMovies("en-US", ApiRequest.API_KEY);

        Response<MovieResponse> response = call.execute();

        assertTrue(response.isSuccessful());
    }
}
