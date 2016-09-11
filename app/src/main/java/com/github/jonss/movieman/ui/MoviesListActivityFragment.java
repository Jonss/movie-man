package com.github.jonss.movieman.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jonss.movieman.R;
import com.github.jonss.movieman.connection.MovieDb;
import com.github.jonss.movieman.connection.RetrofitFactory;
import com.github.jonss.movieman.model.Movie;
import com.github.jonss.movieman.model.Movies;
import com.github.jonss.movieman.ui.adapter.MovieAdapter;
import com.github.jonss.movieman.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A placeholder fragment containing a simple view.
 */
public class MoviesListActivityFragment extends Fragment {

    private RecyclerView moviesListRecyclerView;
    private MovieAdapter mMovieAdapter;
    private Retrofit mRetrofit;
    private MovieDb mMovieDb;
    private GridLayoutManager mLayoutManager;

    public MoviesListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);

        setHasOptionsMenu(true);

        moviesListRecyclerView = (RecyclerView) view.findViewById(R.id.movies_list_recyclerview);

        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        moviesListRecyclerView.setLayoutManager(mLayoutManager);
        mMovieAdapter = new MovieAdapter(getActivity());
        moviesListRecyclerView.setAdapter(mMovieAdapter);

        Retrofit mRetrofit = RetrofitFactory.retrofit();
        mMovieDb = mRetrofit.create(MovieDb.class);
        Call<Movies> call = mMovieDb.listPopularMovies(Constants.API_KEY);
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                updateList(response.body().getMovies());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e("Acesso ao MovieDBAPI", "falhou");
            }
        });

        moviesListRecyclerView.addOnScrollListener(new EndlessScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                Log.d("CurrentPage", String.valueOf(currentPage));
                mMovieDb.listPopularMovies(Constants.API_KEY, currentPage).enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        Log.d("Movies", response.body().getMovies().toString());
                        updateList(response.body().getMovies());
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {
                        Log.e("Acesso ao MovieDBAPI", "no scroll falhou " + call.request().body());
                    }
                });
            }
        });

        return view;
    }

    private void updateList(List<Movie> movies) {
        mMovieAdapter.addAll(movies, getActivity());
        moviesListRecyclerView.getAdapter().notifyDataSetChanged();
    }

}
