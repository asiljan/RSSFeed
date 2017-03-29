package com.android.rssfeed.feeds.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.rssfeed.R;
import com.android.rssfeed.common.BaseFragment;
import com.android.rssfeed.common.helpers.LogHelper;
import com.android.rssfeed.di.components.RssFeedAppComponent;
import com.android.rssfeed.di.modules.RssFeedModule;
import com.android.rssfeed.mvp.presenters.IRssFeedPresenter;
import com.android.rssfeed.mvp.views.RssFeedView;
import com.android.rssfeed.util.ResourceUtil;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedsFragment extends BaseFragment implements RssFeedView, AdapterView.OnItemSelectedListener {

    public static final String TAG = "rss_feeds_fragment";

    @BindView(R.id.feedsDropDownView)
    Spinner mDropDownMenu;
    @BindView(R.id.recyclerView)
    RecyclerView mRssFeedList;

    @Inject
    IRssFeedPresenter mPresenter;

    @Override
    protected void injectDependencies(RssFeedAppComponent appComponent) {
        appComponent.newRssFeedComponent(new RssFeedModule(this)).inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_rssfeed, container, false);

        setHasOptionsMenu(true);

        bindViews();

        setToolbar(ResourceUtil.getStringById(getContext(), R.string.rssFeedToolbarTitle), false);

        return mView;
    }

    private void initAdapter() {

    }

    @Override
    public void onRssFeedsFetched(String[] feedItems) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, feedItems);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDropDownMenu.setOnItemSelectedListener(this);
        mDropDownMenu.setAdapter(dataAdapter);
    }

    @Override
    public void onRssFeedsFailed() {
        //// TODO: 29.3.2017.
    }

    @Override
    public void onShowLoadingBar() {
        showLoadingBar();
    }

    @Override
    public void onHideLoadingBar() {
        hideLoadingBar();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position > 0) {
            LogHelper.printLogMessage("INFO selected item: " + parent.getItemAtPosition(position));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
