package com.android.rssfeed.di.modules;

import com.android.rssfeed.business.IRxJavaSchedulers;
import com.android.rssfeed.di.scopes.RSSFeedAppScope;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alen Siljan on 30.3.2017..
 * alen.siljan@gmail.com
 */
@Module
public class RxJavaModule {

    @Provides
    @RSSFeedAppScope
    IRxJavaSchedulers provideRxJavaSchedulers() {
        return new IRxJavaSchedulers() {
            @Override
            public Scheduler io() {
                return Schedulers.io();
            }

            @Override
            public Scheduler mainThread() {
                return AndroidSchedulers.mainThread();
            }
        };
    }
}
