package com.github.jonss.movieman.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by neuromancer on 04/09/16.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;
    private ImageView thumbnailImageView;
    private TextView overViewTextView;
    private TextView voteAverageTextView;
    private String ReleaseDateImageView;

    public MovieViewHolder(View itemView) {
        super(itemView);

    }
}
