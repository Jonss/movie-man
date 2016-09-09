package com.github.jonss.movieman.connection;

import com.github.jonss.movieman.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by neuromancer on 04/09/16.
 */
public class RetrofitFactory {

    public static Retrofit retrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.MOVIE_DB_URL).build();
    }

}
