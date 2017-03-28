package com.android.rssfeed.di.components;

import com.android.rssfeed.di.modules.PicassoModule;
import com.android.rssfeed.di.scopes.RSSFeedAppScope;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */
@RSSFeedAppScope
@Component(modules = {PicassoModule.class})
public interface RssFeedAppComponent {

    Picasso picasso();
}
