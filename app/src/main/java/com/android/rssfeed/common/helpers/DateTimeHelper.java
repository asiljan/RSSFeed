package com.android.rssfeed.common.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class DateTimeHelper {

    public static final String FEED_DEFAULT_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss";
    public static final String FEED_LIST_ITEM_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm";

    private DateTimeHelper() {

    }

    public static String getDateAndTime(String currentFormatter, String currentDate, String newFormatter) {

        if (currentDate == null || currentDate.isEmpty()) {
            return "";
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(currentFormatter, Locale.getDefault());
            Date newDate = dateFormat.parse(currentDate);
            dateFormat = new SimpleDateFormat(newFormatter, Locale.ENGLISH);
            return dateFormat.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
