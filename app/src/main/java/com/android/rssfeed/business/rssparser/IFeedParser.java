package com.android.rssfeed.business.rssparser;

import com.android.rssfeed.data.models.FeedItemModel;

import java.util.List;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public interface IFeedParser {
    List<FeedItemModel> parse();
}
