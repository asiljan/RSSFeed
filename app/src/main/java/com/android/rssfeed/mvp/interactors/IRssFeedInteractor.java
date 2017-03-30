package com.android.rssfeed.mvp.interactors;

import com.android.rssfeed.data.models.FeedItemModel;
import com.android.rssfeed.mvp.listeners.RssFeedListener;

import java.util.List;

import rx.Observable;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public interface IRssFeedInteractor {
    Observable<List<FeedItemModel>> parseFeed(String feedUrl);

    void getFeeds(RssFeedListener listener);
}
