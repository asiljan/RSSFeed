package com.android.rssfeed.di.components;

import com.android.rssfeed.di.modules.RssFeedModule;
import com.android.rssfeed.di.scopes.FragmentScope;
import com.android.rssfeed.feeds.fragments.RssFeedsFragment;

import dagger.Subcomponent;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */
@FragmentScope
@Subcomponent(modules = RssFeedModule.class)
public interface RssFeedComponent {
    void inject(RssFeedsFragment fragment);
}
