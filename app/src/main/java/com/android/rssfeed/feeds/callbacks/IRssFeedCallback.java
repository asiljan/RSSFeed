package com.android.rssfeed.feeds.callbacks;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public interface IRssFeedCallback {
    void onRssFeedClicked(String url);

    void onAddNewFeedReuqest();

    void onBackRequest();
}
