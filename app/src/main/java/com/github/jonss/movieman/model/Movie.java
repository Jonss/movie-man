package com.github.jonss.movieman.model;

/**
 * Created by neuromancer on 04/09/16.
 */
public class Movie {

    private String title;
    private String imgTumbnail;
    private String overView;
    private Double voteAverage;
    private String ReleaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgTumbnail() {
        return imgTumbnail;
    }

    public void setImgTumbnail(String imgTumbnail) {
        this.imgTumbnail = imgTumbnail;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }
}
