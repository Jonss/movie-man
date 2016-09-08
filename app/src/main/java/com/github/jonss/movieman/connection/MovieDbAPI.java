package com.github.jonss.movieman.connection;

import android.os.AsyncTask;
import android.util.Log;

import com.github.jonss.movieman.util.Constants;
import com.github.jonss.movieman.model.Movie;
import com.github.jonss.movieman.model.Movies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by neuromancer on 04/09/16.
 */
public class MovieDbAPI extends AsyncTask<Void, Void, List<Movie>> {

    private Retrofit retrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.MOVIE_DB_URL).build();
    }

    @Override
    protected List<Movie> doInBackground(Void... params) {
        List<Movie> movieList = new ArrayList<>();
        MovieDb movieDb = retrofit().create(MovieDb.class);
        Call<Movies> listCall = movieDb.listPopularMovies(Constants.API_KEY);
        try {
            movieList = listCall.execute().body().getMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieList;
    }
}
