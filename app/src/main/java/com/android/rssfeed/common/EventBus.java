package com.android.rssfeed.common;

import static org.greenrobot.eventbus.EventBus.getDefault;
/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public class EventBus {
    private static org.greenrobot.eventbus.EventBus instance = getDefault();

    private EventBus() {

    }

    public static org.greenrobot.eventbus.EventBus getInstance() {
        return instance;
    }
}
