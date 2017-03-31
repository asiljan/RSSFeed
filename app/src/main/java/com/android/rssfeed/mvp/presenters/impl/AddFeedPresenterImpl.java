package com.android.rssfeed.mvp.presenters.impl;

import com.android.rssfeed.mvp.interactors.IAddFeedInteractor;
import com.android.rssfeed.mvp.presenters.IAddFeedPresenter;
import com.android.rssfeed.mvp.views.AddFeedView;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */

public class AddFeedPresenterImpl extends BasePresenter implements IAddFeedPresenter {

    AddFeedView mView;
    IAddFeedInteractor mInteractor;

    @Inject
    public AddFeedPresenterImpl(AddFeedView addFeedView, IAddFeedInteractor interactor) {
        this.mView = addFeedView;
        this.mInteractor = interactor;
    }

    @Override
    public void checkFeed(String url) {
        if (url != null && !url.isEmpty()) {
            mView.onShowLoadingBar();
            addSubscription(mInteractor.checkFeed(url)
                    .subscribe(new Subscriber<Integer>() {
                        @Override
                        public void onCompleted() {
                            mView.onHideLoadingBar();
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.onHideLoadingBar();
                        }

                        @Override
                        public void onNext(Integer integer) {
                            if (integer != null) {
                                mView.onNewFeedAdded();
                            }
                        }
                    }));
        } else {
            mView.onNotValidFeedUrl();
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        unsubscribeAll();
    }
}
