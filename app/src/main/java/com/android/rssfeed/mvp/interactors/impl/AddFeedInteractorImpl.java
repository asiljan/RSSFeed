package com.android.rssfeed.mvp.interactors.impl;

import com.android.rssfeed.business.IRxJavaSchedulers;
import com.android.rssfeed.business.rssvalidation.RSSDocumentValidator;
import com.android.rssfeed.common.AppConstants;
import com.android.rssfeed.data.models.RssFeedModel;
import com.android.rssfeed.mvp.interactors.IAddFeedInteractor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */

public class AddFeedInteractorImpl implements IAddFeedInteractor {

    private final DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();

    IRxJavaSchedulers mSchedulers;

    @Inject
    public AddFeedInteractorImpl(IRxJavaSchedulers rxJavaSchedulers) {
        this.mSchedulers = rxJavaSchedulers;
    }

    @Override
    public Observable<Integer> checkFeed(final String url) {
        return Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                final RSSDocumentValidator documentValidator = new RSSDocumentValidator(url);
                String validRssTitle = documentValidator.checkRssUrl();
                if (validRssTitle != null) {
                    RssFeedModel feedModel = new RssFeedModel();
                    feedModel.setFeedUrl(url);
                    feedModel.setTitle(validRssTitle);
                    mRef.child(AppConstants.FEEDS_DB_CHILD).push().setValue(feedModel);
                    return Observable.just(1);
                }
                return null;
            }
        }).subscribeOn(mSchedulers.io()).observeOn(mSchedulers.mainThread());
    }
}
