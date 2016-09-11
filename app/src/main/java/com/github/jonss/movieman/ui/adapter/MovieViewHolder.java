package com.github.jonss.movieman.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.jonss.movieman.R;

/**
 * Created by neuromancer on 04/09/16.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView thumbnailImageView;

    public MovieViewHolder(View itemView) {
        super(itemView);
        thumbnailImageView = (ImageView) itemView.findViewById(R.id.movie_thumbnail_image);
    }

    public void setThumbnailImage(Context context, String thumbnailImage) {
       Glide.with(context).load(thumbnailImage).into(thumbnailImageView);
    }


}
