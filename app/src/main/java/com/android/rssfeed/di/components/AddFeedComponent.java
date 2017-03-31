package com.android.rssfeed.di.components;

import com.android.rssfeed.di.modules.AddFeedModule;
import com.android.rssfeed.di.scopes.FragmentScope;
import com.android.rssfeed.feeds.fragments.AddNewFeedFragment;

import dagger.Subcomponent;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */
@FragmentScope
@Subcomponent(modules = AddFeedModule.class)
public interface AddFeedComponent {
    void inject(AddNewFeedFragment fragment);
}
