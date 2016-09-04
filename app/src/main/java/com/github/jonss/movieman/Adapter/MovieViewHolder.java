package com.github.jonss.movieman.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.jonss.movieman.R;

/**
 * Created by neuromancer on 04/09/16.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView thumbnailImageView;
    private TextView titleTextView;
    private TextView overViewTextView;
    private TextView voteAverageTextView;
    private TextView releaseDateImageView;

    public MovieViewHolder(View itemView) {
        super(itemView);
        thumbnailImageView = (ImageView) itemView.findViewById(R.id.movie_thumbnail_image);
        titleTextView = (TextView) itemView.findViewById(R.id.movie_title_text);
        overViewTextView = (TextView) itemView.findViewById(R.id.movie_overview_text);
        voteAverageTextView = (TextView) itemView.findViewById(R.id.movie_overview_text);
        releaseDateImageView = (TextView) itemView.findViewById(R.id.movie_release_date_text);
    }

    public void setThumbnailImage(Context context, String thumbnailImage) {
        Glide.with(context).load(thumbnailImage).into(thumbnailImageView);
    }

    public void setTitleTextView(String title) {
        this.titleTextView.setText(title);
    }

    public void setOverViewTextView(String overView) {
        this.overViewTextView.setText(overView);
    }

    public void setVoteAverageTextView(Double voteAverage) {
        this.voteAverageTextView.setText(String.valueOf(voteAverage));
    }

    public void setReleaseDateImageView(String releaseDate) {
        this.releaseDateImageView.setText(releaseDate);
    }

}
