package com.android.rssfeed.mvp.views;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public interface RssFeedView extends BaseView {
    void onRssFeedsFetched(String[] feedItems);

    void onRssFeedsFailed();
}
