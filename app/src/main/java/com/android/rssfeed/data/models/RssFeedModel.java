package com.android.rssfeed.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedModel {
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("url")
    @Expose
    private String mFeedUrl;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getFeedUrl() {
        return mFeedUrl;
    }

    public void setFeedUrl(String mFeedUrl) {
        this.mFeedUrl = mFeedUrl;
    }
}
