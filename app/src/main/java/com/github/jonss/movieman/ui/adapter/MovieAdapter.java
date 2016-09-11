package com.github.jonss.movieman.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jonss.movieman.R;
import com.github.jonss.movieman.model.Movie;
import com.github.jonss.movieman.ui.MovieItemActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neuromancer on 04/09/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final LayoutInflater mInflater;
    private List<Movie> movies;
    private Movie movie;
    private Context mContext;

    public MovieAdapter(Context context) {
        movies = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
        mContext = mInflater.getContext();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = mInflater.inflate(R.layout.movie_item, parent, false);
        final MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = movies.get(movieViewHolder.getAdapterPosition());
                Intent intent = new Intent(mContext, MovieItemActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, movie);
                mContext.startActivity(intent);
            }
        });
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        movie = movies.get(position);
        holder.setThumbnailImage(mContext, movie.getPosterPath());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public MovieAdapter addAll(final List<Movie> movies, final Activity activity) {
        this.movies.addAll(movies);
        mContext = activity;
        return this;
    }
}
