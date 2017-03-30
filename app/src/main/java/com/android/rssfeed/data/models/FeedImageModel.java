package com.android.rssfeed.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alen Siljan on 30.3.2017..
 * alen.siljan@gmail.com
 */

public class FeedImageModel {
    @SerializedName("url")
    @Expose
    private String mUrl;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
