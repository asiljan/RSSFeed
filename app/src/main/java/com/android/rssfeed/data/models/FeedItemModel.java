package com.android.rssfeed.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class FeedItemModel {
    @SerializedName("pubDate")
    @Expose
    private String mPubDate;
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("description")
    @Expose
    private String mDescription;
    @SerializedName("link")
    @Expose
    private String mLink;

    public String getPubDate() {
        return mPubDate;
    }

    public void setPubDate(String mPubDate) {
        this.mPubDate = mPubDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String mLink) {
        this.mLink = mLink;
    }
}
