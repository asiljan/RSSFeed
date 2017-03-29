package com.android.rssfeed.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.android.rssfeed.R;
import com.android.rssfeed.RSSFeedApplication;
import com.android.rssfeed.di.components.RssFeedAppComponent;
import com.android.rssfeed.feeds.callbacks.IRssFeedCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @BindView(R.id.loadingBar)
    ProgressBar mLoadingBar;
    @Nullable
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    protected View mView;
    private Unbinder mUnbinder;

    protected IRssFeedCallback mCallback;

    protected abstract void injectDependencies(RssFeedAppComponent appComponent);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (IRssFeedCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement RSS Feed callback");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies(RSSFeedApplication.getInstance().getAppComponent());
    }

    protected void bindViews() {
        mUnbinder = ButterKnife.bind(this, mView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    protected void showLoadingBar() {
        if (mLoadingBar != null) {
            mLoadingBar.setVisibility(View.VISIBLE);
        }
    }

    protected void hideLoadingBar() {
        if (mLoadingBar != null) {
            mLoadingBar.setVisibility(View.GONE);
        }
    }

    protected void setToolbar(String title, boolean displayHome) {
        if (getActivity() != null) {
            ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        }

        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            if (displayHome) {
                ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        }
    }
}
