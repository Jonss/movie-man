package com.github.jonss.movieman.connection;

import retrofit2.Retrofit;

/**
 * Created by neuromancer on 04/09/16.
 */
public class MovieDbAPI {

    private static final String movieDburl = "https://api.themoviedb.org";
    private static final String apiKey = "ffe5d57214e7ec8915384274cc5181ef";

    private Retrofit retrofit() {
        return new Retrofit.Builder().baseUrl(movieDburl).build();
    }


}
