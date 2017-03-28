package com.android.rssfeed;

import android.app.Application;

import com.android.rssfeed.di.components.DaggerRssFeedAppComponent;
import com.android.rssfeed.di.components.RssFeedAppComponent;
import com.android.rssfeed.di.modules.AppModule;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public class RSSFeedApplication extends Application {

    private static RSSFeedApplication instance = null;
    private RssFeedAppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);

        mAppComponent = DaggerRssFeedAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static void setInstance(RSSFeedApplication instance) {
        RSSFeedApplication.instance = instance;
    }

    public static RSSFeedApplication getInstance() {
        return instance;
    }

    public RssFeedAppComponent getAppComponent() {
        return mAppComponent;
    }
}
