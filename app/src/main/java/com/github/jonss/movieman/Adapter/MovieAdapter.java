package com.github.jonss.movieman.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jonss.movieman.R;
import com.github.jonss.movieman.model.Movie;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by neuromancer on 04/09/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final LayoutInflater mInflater;
    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movie_item, parent);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.setThumbnailImage(mInflater.getContext(), movie.getImgThumbnail());
        holder.setTitleTextView(movie.getTitle());
        holder.setVoteAverageTextView(movie.getVoteAverage());
        holder.setOverViewTextView(movie.getOverView());
        holder.setReleaseDateImageView(movie.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
