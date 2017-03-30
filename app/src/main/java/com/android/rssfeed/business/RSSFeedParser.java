package com.android.rssfeed.business;

import android.util.Xml;

import com.android.rssfeed.common.helpers.LogHelper;
import com.android.rssfeed.data.models.FeedItemModel;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen Siljan on 29.3.2017..
 * alen.siljan@gmail.com
 */

public class RSSFeedParser extends BaseFeedParser {

    public RSSFeedParser(String feedUrl) {
        super(feedUrl);
    }

    public List<FeedItemModel> parse() {
        List<FeedItemModel> messages = null;
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(this.getInputStream(), null);
            int eventType = parser.getEventType();
            FeedItemModel currentMessage = null;
            boolean done = false;
            while (eventType != XmlPullParser.END_DOCUMENT && !done) {
                String name = null;
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        messages = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG:
                        name = parser.getName();
                        if (name.equalsIgnoreCase(ITEM)) {
                            currentMessage = new FeedItemModel();
                        } else if (currentMessage != null) {
                            if (name.equalsIgnoreCase(LINK)) {
                                currentMessage.setLink(parser.nextText());
                            } else if (name.equalsIgnoreCase(DESCRIPTION)) {
                                currentMessage.setDescription(parser.nextText());
                            } else if (name.equalsIgnoreCase(PUB_DATE)) {
                                currentMessage.setPubDate(parser.nextText());
                            } else if (name.equalsIgnoreCase(TITLE)) {
                                currentMessage.setTitle(parser.nextText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        name = parser.getName();
                        if (name.equalsIgnoreCase(ITEM) && currentMessage != null) {
                            messages.add(currentMessage);
                        } else if (name.equalsIgnoreCase(CHANNEL)) {
                            done = true;
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            LogHelper.printLogMessage(e.getMessage());
            throw new RuntimeException(e);
        }
        return messages;
    }
}
