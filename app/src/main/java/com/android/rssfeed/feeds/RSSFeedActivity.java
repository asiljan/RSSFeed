package com.android.rssfeed.feeds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.rssfeed.R;
import com.android.rssfeed.data.events.RssFeedItemClickEvent;
import com.android.rssfeed.feeds.callbacks.IRssFeedCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class RSSFeedActivity extends AppCompatActivity implements IRssFeedCallback {

    public static final int FRAGMENT_HOLDER = R.id.fragment_holder;

    private RssFeedFragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);

        mFragmentManager = new RssFeedFragmentManager(getSupportFragmentManager());

        mFragmentManager.showRssFeedListFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onRssFeedItemEvent(RssFeedItemClickEvent itemClickEvent) {
        mFragmentManager.showRssFeedDetailsFragment(itemClickEvent.getFeedWebsiteUrl());
    }

    @Override
    public void onRssFeedClicked(String url) {
        //// TODO: 28.3.2017.
    }

    @Override
    public void onAddNewFeedReuqest() {
        mFragmentManager.showRssAddNewFeedFragment();
    }

    @Override
    public void onBackRequest() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (mFragmentManager.backStackGreatherThanOne()) {
            super.onBackPressed();
        } else {
            this.finish();
        }
    }
}
