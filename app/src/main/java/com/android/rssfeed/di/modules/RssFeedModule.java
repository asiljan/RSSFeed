package com.android.rssfeed.di.modules;

import android.content.Context;

import com.android.rssfeed.data.models.RssFeedModel;
import com.android.rssfeed.di.scopes.FragmentScope;
import com.android.rssfeed.feeds.adapters.RssFeedAdapter;
import com.android.rssfeed.mvp.interactors.IRssFeedInteractor;
import com.android.rssfeed.mvp.interactors.impl.RssFeedInteractorImpl;
import com.android.rssfeed.mvp.presenters.IRssFeedPresenter;
import com.android.rssfeed.mvp.presenters.impl.RssFeedPresenterImpl;
import com.android.rssfeed.mvp.views.RssFeedView;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */
@Module
public class RssFeedModule {
    private final RssFeedView mView;

    public RssFeedModule(RssFeedView rssFeedView) {
        this.mView = rssFeedView;
    }

    @Provides
    @FragmentScope
    public RssFeedView provideRssFeedView() {
        return mView;
    }

    @Provides
    @FragmentScope
    public IRssFeedInteractor provideRssFeedInteractor(RssFeedInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @FragmentScope
    public IRssFeedPresenter provideRssFeedPresenter(RssFeedPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @FragmentScope
    public RssFeedAdapter provideRssFeedAdapter(Context context, Picasso picasso) {
        return new RssFeedAdapter(context, picasso);
    }
}
