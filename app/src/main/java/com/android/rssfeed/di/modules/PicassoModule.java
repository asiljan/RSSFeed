package com.android.rssfeed.di.modules;

import android.content.Context;

import com.android.rssfeed.di.scopes.RSSFeedAppScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */
@RSSFeedAppScope
@Module(includes = {AppModule.class, NetworkModule.class})
public class PicassoModule {
    @Provides
    @RSSFeedAppScope
    public OkHttp3Downloader provideHttp3Downloader(OkHttpClient httpClient) {
        return new OkHttp3Downloader(httpClient);
    }

    @Provides
    @RSSFeedAppScope
    public Picasso providePicasso(Context context, OkHttp3Downloader http3Downloader) {
        return new Picasso.Builder(context)
                .downloader(http3Downloader)
                .build();
    }
}
