package com.android.rssfeed.mvp.views;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */

public interface AddFeedView extends BaseView {
    void onNewFeedAdded();

    void onNotValidFeedUrl();
}
