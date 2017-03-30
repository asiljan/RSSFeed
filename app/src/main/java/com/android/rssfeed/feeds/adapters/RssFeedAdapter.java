package com.android.rssfeed.feeds.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.rssfeed.R;
import com.android.rssfeed.data.models.FeedItemModel;
import com.android.rssfeed.feeds.viewholders.RssFeedItemViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mInflater;
    Picasso mPicasso;
    private List<FeedItemModel> mFeedItems;

    public RssFeedAdapter(Context context, Picasso picasso) {
        this.mInflater = LayoutInflater.from(context);
        this.mPicasso = picasso;
        this.mFeedItems = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_rssfeed, parent, false);

        return new RssFeedItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedItemModel itemModel = mFeedItems.get(position);

        RssFeedItemViewHolder feedItemViewHolder = (RssFeedItemViewHolder) holder;

        feedItemViewHolder.bindData(itemModel, mPicasso);
    }

    @Override
    public int getItemCount() {
        return mFeedItems != null ? mFeedItems.size() : 0;
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        holder.itemView.setOnClickListener(null);
        super.onViewRecycled(holder);
    }

    public void updateFeedItems(List<FeedItemModel> items) {
        this.mFeedItems.clear();
        this.mFeedItems.addAll(items);

        notifyDataSetChanged();
    }
}
