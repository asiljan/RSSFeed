package com.android.rssfeed.di.modules;

import com.android.rssfeed.di.scopes.FragmentScope;
import com.android.rssfeed.mvp.interactors.IAddFeedInteractor;
import com.android.rssfeed.mvp.interactors.impl.AddFeedInteractorImpl;
import com.android.rssfeed.mvp.presenters.IAddFeedPresenter;
import com.android.rssfeed.mvp.presenters.impl.AddFeedPresenterImpl;
import com.android.rssfeed.mvp.views.AddFeedView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */
@Module
public class AddFeedModule {
    private final AddFeedView mView;

    public AddFeedModule(AddFeedView addFeedView) {
        this.mView = addFeedView;
    }

    @Provides
    @FragmentScope
    public AddFeedView provideAddFeedView() {
        return mView;
    }

    @Provides
    @FragmentScope
    public IAddFeedInteractor provideAddFeedInteractor(AddFeedInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @FragmentScope
    public IAddFeedPresenter provideAddFeedPresenter(AddFeedPresenterImpl presenter) {
        return presenter;
    }
}
