package com.android.rssfeed.mvp.listeners;

import com.android.rssfeed.data.models.RssFeedModel;

import java.util.List;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public interface RssFeedListener {
    void onRssFeedsFetched(List<RssFeedModel> feeds);
}
