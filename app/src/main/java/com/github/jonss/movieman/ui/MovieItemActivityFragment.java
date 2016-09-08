package com.github.jonss.movieman.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.jonss.movieman.R;
import com.github.jonss.movieman.model.Movie;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieItemActivityFragment extends Fragment {

    public MovieItemActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_item, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.movie_image);
        TextView overview = (TextView) view.findViewById(R.id.movie_overview_text);
        TextView title = (TextView) view.findViewById(R.id.movie_title);
        TextView voteAverage = (TextView) view.findViewById(R.id.movie_vote_average);
        TextView releaseDate = (TextView) view.findViewById(R.id.movie_release_date);

        Intent intent = getActivity().getIntent();
        Movie movie = (Movie) intent.getSerializableExtra(Intent.EXTRA_TEXT);

        Glide.with(getActivity()).load(movie.getPosterPath()).into(imageView);
        overview.setText(movie.getOverview());
        title.setText(movie.getOriginalTitle());
        voteAverage.setText(movie.getVoteAverage().toString());
        releaseDate.setText(movie.getReleaseDate());

        return view;
    }
}
