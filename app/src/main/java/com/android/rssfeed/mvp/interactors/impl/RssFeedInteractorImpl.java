package com.android.rssfeed.mvp.interactors.impl;

import com.android.rssfeed.business.IRxJavaSchedulers;
import com.android.rssfeed.business.RSSFeedParser;
import com.android.rssfeed.common.AppConstants;
import com.android.rssfeed.data.models.FeedItemModel;
import com.android.rssfeed.data.models.RssFeedModel;
import com.android.rssfeed.mvp.interactors.IRssFeedInteractor;
import com.android.rssfeed.mvp.listeners.RssFeedListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedInteractorImpl implements IRssFeedInteractor {

    private final DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();

    private RssFeedListener mListener;
    IRxJavaSchedulers mRxSchedulers;

    @Inject
    public RssFeedInteractorImpl(IRxJavaSchedulers rxJavaSchedulers) {
        this.mRxSchedulers = rxJavaSchedulers;
    }

    @Override
    public Observable<List<FeedItemModel>> parseFeed(String feedUrl) {
        final RSSFeedParser parser = new RSSFeedParser(feedUrl);
        return Observable.defer(new Func0<Observable<List<FeedItemModel>>>() {
            @Override
            public Observable<List<FeedItemModel>> call() {
                return Observable.just(parser.parse());
            }
        }).subscribeOn(mRxSchedulers.io()).observeOn(mRxSchedulers.mainThread());
    }

    @Override
    public void getFeeds(RssFeedListener listener) {
        this.mListener = listener;

        mRef.child(AppConstants.FEEDS_DB_CHILD).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<RssFeedModel> feeds = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    feeds.add(ds.getValue(RssFeedModel.class));
                }

                mListener.onRssFeedsFetched(feeds);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                mListener.onRssFeedsFetched(null);
            }
        });
    }
}
