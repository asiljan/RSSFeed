package com.android.rssfeed.business.rssvalidation;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Alen Siljan on 31.3.2017..
 * alen.siljan@gmail.com
 */

public abstract class BaseDocumentValidator implements IDocumentValidator {

    static final String RSS = "rss";
    static final String CHANNEL = "channel";

    protected Document mDocument;

    protected BaseDocumentValidator(String url) {
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.mDocument = dBuilder.parse(new URL(url).openConnection().getInputStream());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
            return;
//            throw new RuntimeException(e);
        }
    }
}
