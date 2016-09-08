package com.github.jonss.movieman.ui;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jonss.movieman.Adapter.MovieAdapter;
import com.github.jonss.movieman.R;
import com.github.jonss.movieman.connection.MovieDbAPI;
import com.github.jonss.movieman.model.Movie;
import com.github.jonss.movieman.model.Movies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * A placeholder fragment containing a simple view.
 */
public class MoviesListActivityFragment extends Fragment {

    private RecyclerView moviesListRecyclerView;
    private MovieAdapter mMovieAdapter;

    public MoviesListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);

        moviesListRecyclerView = (RecyclerView) view.findViewById(R.id.movies_list_recyclerview);
        List<Movie> movies = getMovies();
        mMovieAdapter = new MovieAdapter(movies, getActivity());
        moviesListRecyclerView.setAdapter(mMovieAdapter);
        moviesListRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }

    private List<Movie> getMovies() {
        List<Movie> movies= new ArrayList<>();
        MovieDbAPI movieDbAPI = new MovieDbAPI();
        AsyncTask<Void, Void, List<Movie>> execute = movieDbAPI.execute();
        try {
            movies =  execute.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return movies;
    }

}
