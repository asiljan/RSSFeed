package com.android.rssfeed.business;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public abstract class BaseFeedParser implements IFeedParser {

    // names of the XML tags
    static final String CHANNEL = "channel";
    static final String PUB_DATE = "pubDate";
    static final  String DESCRIPTION = "description";
    static final  String LINK = "link";
    static final  String TITLE = "title";
    static final  String ITEM = "item";
    static final String IMAGE = "image";
    static final String IMG_URL = "url";
    private final URL mFeedUrl;

    protected BaseFeedParser(String feedUrl){
        try {
            this.mFeedUrl = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected InputStream getInputStream() {
        try {
            return mFeedUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
