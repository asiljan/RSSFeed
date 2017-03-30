package com.android.rssfeed.di.components;

import com.android.rssfeed.business.IRxJavaSchedulers;
import com.android.rssfeed.di.modules.PicassoModule;
import com.android.rssfeed.di.modules.RssFeedModule;
import com.android.rssfeed.di.modules.RxJavaModule;
import com.android.rssfeed.di.scopes.RSSFeedAppScope;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */
@RSSFeedAppScope
@Component(modules = {PicassoModule.class, RxJavaModule.class})
public interface RssFeedAppComponent {

    Picasso picasso();

    IRxJavaSchedulers rxJavaSchedulers();

    RssFeedComponent newRssFeedComponent(RssFeedModule rssFeedModule);
}
