package com.android.rssfeed.business.rssvalidation;

import com.android.rssfeed.common.helpers.LogHelper;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */

public class RSSDocumentValidator extends BaseDocumentValidator {

    public RSSDocumentValidator(String url) {
        super(url);
    }

    @Override
    public String checkRssUrl() {
        if (mDocument.getDocumentElement().getNodeName().equalsIgnoreCase(RSS)) {
            String feedTitle = null;
            Node node = mDocument.getDocumentElement();
            NodeList nodeList = node.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node current = nodeList.item(i);
                if (current.getNodeName().equalsIgnoreCase(CHANNEL)) {
                    Node titleNode = current.getChildNodes().item(1);
                    feedTitle = titleNode.getTextContent();
                    break;
                }
            }
            LogHelper.printLogMessage("INFO store into Firebase database feed: " + feedTitle);
            return feedTitle;
        }

        return null;
    }
}
