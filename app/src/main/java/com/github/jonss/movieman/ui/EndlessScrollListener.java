package com.github.jonss.movieman.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by neuromancer on 08/09/16.
 */
public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    private int visibleItemCount, mFirstVisibleItem, mTotalItemCount;
    private LinearLayoutManager mLayoutManager;
    private boolean loading = true;
    private int previousTotal = 0;
    private int currentPage = 1;
    private int visibleThreshold = 6;

    public EndlessScrollListener(LinearLayoutManager layoutManager) {
        mLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        mTotalItemCount = mLayoutManager.getItemCount();
        mFirstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();

        if (loading) {
            if (mTotalItemCount > previousTotal) {
                loading = false;
                previousTotal = mTotalItemCount;
            }
        }

        if (!loading && (mTotalItemCount - previousTotal)
                <= (mFirstVisibleItem + visibleThreshold)) {
            currentPage++;
            onLoadMore(currentPage);
            loading = true;
        }

    }

    public abstract void onLoadMore(int currentPage);
}
