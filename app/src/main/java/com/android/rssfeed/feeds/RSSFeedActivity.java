package com.android.rssfeed.feeds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.rssfeed.R;
import com.android.rssfeed.feeds.callbacks.IRssFeedCallback;

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
    public void onRssFeedClicked(String url) {
        //// TODO: 28.3.2017.
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
