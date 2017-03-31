package com.android.rssfeed.fcm;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */

public class MyFirebaseInstanceService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        //// TODO: 31.3.2017. store fcm token on server
    }
}
