package com.android.rssfeed.feeds;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.android.rssfeed.feeds.fragments.AddNewFeedFragment;
import com.android.rssfeed.feeds.fragments.RssFeedDetailsFragment;
import com.android.rssfeed.feeds.fragments.RssFeedsFragment;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedFragmentManager {

    private FragmentManager mFragmentManager;

    public RssFeedFragmentManager(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public void showRssFeedListFragment() {
        FragmentTransaction fTransaction = mFragmentManager.beginTransaction();
        RssFeedsFragment fragment = new RssFeedsFragment();
        fTransaction.replace(RSSFeedActivity.FRAGMENT_HOLDER, fragment, RssFeedsFragment.TAG);
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }

    public void showRssFeedDetailsFragment(String url) {
        FragmentTransaction fTransaction = mFragmentManager.beginTransaction();
        RssFeedDetailsFragment fragment = RssFeedDetailsFragment.newInstance(url);
        fTransaction.replace(RSSFeedActivity.FRAGMENT_HOLDER, fragment, RssFeedDetailsFragment.TAG);
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }

    public void showRssAddNewFeedFragment() {
        FragmentTransaction fTransaction = mFragmentManager.beginTransaction();
        AddNewFeedFragment fragment = new AddNewFeedFragment();
        fTransaction.replace(RSSFeedActivity.FRAGMENT_HOLDER, fragment, AddNewFeedFragment.TAG);
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }

    public boolean backStackGreatherThanOne() {
        return mFragmentManager.getBackStackEntryCount() > 1;
    }
}
