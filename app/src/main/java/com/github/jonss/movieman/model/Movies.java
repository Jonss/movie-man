package com.github.jonss.movieman.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by neuromancer on 07/09/16.
 */
public class Movies {

    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
