package com.github.jonss.movieman.model;

import com.github.jonss.movieman.util.Constants;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by neuromancer on 04/09/16.
 */
public class Movie implements Serializable {

    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_average")
    private Double voteAverage;
    @SerializedName("release_date")
    private String releaseDate;

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPosterPath() {
        return Constants.IMAGE_URL + posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

}
