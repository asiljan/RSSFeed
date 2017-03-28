package com.android.rssfeed;

import android.app.Application;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public class RSSFeedApplication extends Application {

    private static RSSFeedApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);
    }

    public static void setInstance(RSSFeedApplication instance) {
        RSSFeedApplication.instance = instance;
    }

    public static RSSFeedApplication getInstance() {
        return instance;
    }
}
