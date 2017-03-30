package com.android.rssfeed.business;

import rx.Scheduler;

/**
 * Created by Alen Siljan on 30.3.2017..
 * alen.siljan@gmail.com
 */

public interface IRxJavaSchedulers {
    Scheduler io();

    Scheduler mainThread();
}
