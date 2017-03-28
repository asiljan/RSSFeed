package com.android.rssfeed.di.modules;

import android.content.Context;

import com.android.rssfeed.di.scopes.RSSFeedAppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */
@Module
public class AppModule {

    private final Context mContext;

    public AppModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @RSSFeedAppScope
    public Context provideContext() {
        return mContext;
    }
}
