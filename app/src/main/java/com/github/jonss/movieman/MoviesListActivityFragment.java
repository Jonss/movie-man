package com.github.jonss.movieman;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MoviesListActivityFragment extends Fragment {

        //https://api.themoviedb.org/list?api_key=ffe5d57214e7ec8915384274cc5181ef

    private RecyclerView moviesListRecyclerView;

    public MoviesListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);


        return view;
    }
}
