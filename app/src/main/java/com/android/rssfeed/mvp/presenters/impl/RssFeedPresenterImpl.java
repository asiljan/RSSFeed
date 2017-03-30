package com.android.rssfeed.mvp.presenters.impl;

import com.android.rssfeed.data.models.FeedItemModel;
import com.android.rssfeed.data.models.RssFeedModel;
import com.android.rssfeed.mvp.interactors.IRssFeedInteractor;
import com.android.rssfeed.mvp.listeners.RssFeedListener;
import com.android.rssfeed.mvp.presenters.IRssFeedPresenter;
import com.android.rssfeed.mvp.views.RssFeedView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedPresenterImpl extends BasePresenter implements IRssFeedPresenter, RssFeedListener {

    RssFeedView mView;
    IRssFeedInteractor mInteractor;

    private List<RssFeedModel> mFeeds;

    @Inject
    public RssFeedPresenterImpl(RssFeedView rssFeedView, IRssFeedInteractor interactor) {
        this.mView = rssFeedView;
        this.mInteractor = interactor;
    }

    @Override
    public void onStart() {
        mView.onShowLoadingBar();
        mInteractor.getFeeds(this);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onFeedSelected(int position) {
        mView.onShowLoadingBar();
        String feedUrl = mFeeds.get(position - 1).getFeedUrl();
        addSubscription(mInteractor.parseFeed(feedUrl)
                .subscribe(new Subscriber<List<FeedItemModel>>() {
                    @Override
                    public void onCompleted() {
                        mView.onHideLoadingBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onHideLoadingBar();
                    }

                    @Override
                    public void onNext(List<FeedItemModel> feedItemModels) {
                        if (feedItemModels != null) {
                            mView.onFeedParsed(feedItemModels);
                        } else {
                            mView.onFeedParseFail();
                        }
                    }
                }));
    }

    @Override
    public void onRssFeedsFetched(List<RssFeedModel> feeds) {
        mView.onHideLoadingBar();
        if (feeds != null) {
            this.mFeeds = feeds;
            String[] items = new String[mFeeds.size() + 1];
            items[0] = "Select Feed";
            for (int i = 0; i < mFeeds.size(); i++) {
                RssFeedModel feed = mFeeds.get(i);
                items[i + 1] = feed.getTitle();
            }

            mView.onRssFeedsFetched(items);
        } else {
            mView.onRssFeedsFailed();
        }
    }
}
