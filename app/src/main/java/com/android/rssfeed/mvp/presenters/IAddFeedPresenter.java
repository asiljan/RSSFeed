package com.android.rssfeed.mvp.presenters;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */

public interface IAddFeedPresenter extends IBasePresenter {
    void checkFeed(String url);
}
