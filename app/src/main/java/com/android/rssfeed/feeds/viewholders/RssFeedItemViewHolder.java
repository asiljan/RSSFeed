package com.android.rssfeed.feeds.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.rssfeed.R;
import com.android.rssfeed.common.helpers.DateTimeHelper;
import com.android.rssfeed.data.events.RssFeedItemClickEvent;
import com.android.rssfeed.data.models.FeedItemModel;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.itemFeedHolder)
    LinearLayout mHolder;
    @BindView(R.id.itemFeedPubDate)
    TextView mFeedDate;
    @BindView(R.id.itemFeedTitle)
    TextView mFeedTitle;
    @BindView(R.id.itemFeedDescription)
    TextView mFeedDescription;
    @BindView(R.id.itemFeedIcon)
    ImageView mFeedIcon;

    String mFeedWebsiteUrl;

    public RssFeedItemViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bindData(FeedItemModel feedItemModel, Picasso picasso) {
        this.mFeedWebsiteUrl = feedItemModel.getLink();

        picasso
                .load(feedItemModel.getImage().getUrl())
                .into(mFeedIcon);

        mFeedDate.setText(DateTimeHelper.getDateAndTime(DateTimeHelper.FEED_DEFAULT_TIME_FORMAT,
                feedItemModel.getPubDate(), DateTimeHelper.FEED_LIST_ITEM_TIME_FORMAT));

        mFeedTitle.setText(feedItemModel.getTitle());
        mFeedDescription.setText(feedItemModel.getDescription());

        mHolder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new RssFeedItemClickEvent(mFeedWebsiteUrl));
    }
}
