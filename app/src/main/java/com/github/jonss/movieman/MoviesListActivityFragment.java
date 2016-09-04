package com.github.jonss.movieman;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jonss.movieman.Adapter.MovieAdapter;
import com.github.jonss.movieman.connection.MoviesAsyncTask;
import com.github.jonss.movieman.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MoviesListActivityFragment extends Fragment {
    //https://api.themoviedb.org/list?api_key=ffe5d57214e7ec8915384274cc5181ef

    private RecyclerView moviesListRecyclerView;
    private MovieAdapter mMovieAdapter;
    private final FragmentActivity mActivity;

    public MoviesListActivityFragment() {
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);

        moviesListRecyclerView = (RecyclerView) view.findViewById(R.id.movies_list_recyclerview);
        mMovieAdapter = new MovieAdapter(new ArrayList<Movie>(), mActivity);
        moviesListRecyclerView.setAdapter(mMovieAdapter);
        moviesListRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        return view;
    }

    private void getMovies(){
        new MoviesAsyncTask();
    }

}
