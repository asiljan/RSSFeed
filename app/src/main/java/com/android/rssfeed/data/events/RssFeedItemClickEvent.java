package com.android.rssfeed.data.events;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedItemClickEvent {
    private String mFeedWebsiteUrl;

    public RssFeedItemClickEvent(String websiteUrl) {
        this.mFeedWebsiteUrl = websiteUrl;
    }

    public String getFeedWebsiteUrl() {
        return mFeedWebsiteUrl;
    }
}
