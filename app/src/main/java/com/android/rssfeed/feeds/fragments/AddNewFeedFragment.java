package com.android.rssfeed.feeds.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.rssfeed.R;
import com.android.rssfeed.common.BaseFragment;
import com.android.rssfeed.common.views.AppButtonView;
import com.android.rssfeed.di.components.RssFeedAppComponent;
import com.android.rssfeed.di.modules.AddFeedModule;
import com.android.rssfeed.mvp.presenters.IAddFeedPresenter;
import com.android.rssfeed.mvp.views.AddFeedView;
import com.android.rssfeed.util.ResourceUtil;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alen Siljan on 30.3.2017..
 * alen.siljan@gmail.com
 */

public class AddNewFeedFragment extends BaseFragment implements AddFeedView, View.OnClickListener {

    public static final String TAG = "add_new_feed_fragment";

    @BindView(R.id.addFeedInputView)
    EditText mInputField;
    @BindView(R.id.addFeedButton)
    AppButtonView mAddFeedButton;

    @Inject
    IAddFeedPresenter mPresenter;

    @Override
    protected void injectDependencies(RssFeedAppComponent appComponent) {
        appComponent.newAddFeedComponent(new AddFeedModule(this)).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_add_feed, container, false);

        bindViews();

        setHasOptionsMenu(true);

        setToolbar(ResourceUtil.getStringById(getContext(), R.string.menuAddFeedTitle), true);
        mAddFeedButton.setOnClickListener(this);

        return mView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mCallback.onBackRequest();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        mPresenter.checkFeed(mInputField.getText().toString().trim());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onNewFeedAdded() {
        mCallback.onBackRequest();
    }

    @Override
    public void onNotValidFeedUrl() {
        Toast.makeText(getContext(), ResourceUtil.getStringById(getContext(),
                R.string.rssFeedUrlNotValid), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowLoadingBar() {

    }

    @Override
    public void onHideLoadingBar() {

    }
}
