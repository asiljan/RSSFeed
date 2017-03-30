package com.android.rssfeed.mvp.views;

import com.android.rssfeed.data.models.FeedItemModel;

import java.util.List;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public interface RssFeedView extends BaseView {
    void onRssFeedsFetched(String[] feedItems);

    void onRssFeedsFailed();

    void onFeedParseFail();

    void onFeedParsed(List<FeedItemModel> feedItems);
}
