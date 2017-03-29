package com.android.rssfeed.common.helpers;

import com.android.rssfeed.BuildConfig;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class LogHelper {

    private static final String TAG = "RSSFeed";
    private static boolean LOG_ENABLED = BuildConfig.DEBUG;

    private LogHelper() {

    }

    public static void printLogMessage(String msg) {
        if (LOG_ENABLED) {
            System.out.println(TAG + ":" + msg);
        }
    }
}
