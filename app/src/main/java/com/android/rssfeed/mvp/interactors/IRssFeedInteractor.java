package com.android.rssfeed.mvp.interactors;

import com.android.rssfeed.mvp.listeners.RssFeedListener;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public interface IRssFeedInteractor {
    void getFeeds(RssFeedListener listener);
}
