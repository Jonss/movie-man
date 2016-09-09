package com.github.jonss.movieman.connection;

import com.github.jonss.movieman.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by neuromancer on 04/09/16.
 */
public interface MovieDb {

    @GET("movie/popular")
    Call<Movies> listPopularMovies(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("movie/popular")
    Call<Movies> listPopularMovies(@Query("api_key") String apiKey);
}
