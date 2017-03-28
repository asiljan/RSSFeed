package com.android.rssfeed.di.modules;

import android.content.Context;

import com.android.rssfeed.di.scopes.RSSFeedAppScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */
@RSSFeedAppScope
@Module(includes = AppModule.class)
public class NetworkModule {
    @Provides
    @RSSFeedAppScope
    public File provideFileCache(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @RSSFeedAppScope
    public Cache provideCache(File cacheFile) {
        try {
            int cacheSize = 10 * 1024 * 1024;
            return new Cache(cacheFile, cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Provides
    @RSSFeedAppScope
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @RSSFeedAppScope
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }
}
