package com.android.rssfeed.mvp.presenters;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public interface IBasePresenter {
    void onStart();

    void onStop();

    void onDestroy();
}
