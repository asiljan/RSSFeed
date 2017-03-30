package com.android.rssfeed.mvp.presenters.impl;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Alen Siljan on 30.3.2017..
 * alen.siljan@gmail.com
 */

public abstract class BasePresenter {
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    public void addSubscription(Subscription subscription) {
        mCompositeSubscription.add(subscription);
    }

    public void unsubscribeAll() {
        mCompositeSubscription.clear();
    }
}
