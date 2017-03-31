package com.android.rssfeed.mvp.interactors;

import rx.Observable;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */

public interface IAddFeedInteractor {
    Observable<Integer> checkFeed(String url);
}
