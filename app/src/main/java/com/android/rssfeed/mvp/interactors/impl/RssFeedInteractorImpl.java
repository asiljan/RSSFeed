package com.android.rssfeed.mvp.interactors.impl;

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

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedInteractorImpl implements IRssFeedInteractor {

    private static final String FEED_CHILD_NODE = "feeds";
    private final DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();

    private RssFeedListener mListener;

    @Inject
    public RssFeedInteractorImpl() {

    }

    @Override
    public void getFeeds(RssFeedListener listener) {
        this.mListener = listener;

        mRef.child(FEED_CHILD_NODE).addValueEventListener(new ValueEventListener() {
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
