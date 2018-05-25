package com.example.android.movienews;

import org.joda.time.DateTime;

import java.sql.Date;

public class News {

    private String mSectionName;
    private String mUrl;
    private String mWebTitle;
    private DateTime mDate;
    private String mAuthor;

    public News(String sectionName, String webTitle, String author, DateTime date, String url) {
        mSectionName = sectionName;
        mWebTitle = webTitle;
        mAuthor = author;
        mDate = date;
        mUrl = url;
    }

    public News(String sectionName, String webTitle, DateTime date, String url) {
        mSectionName = sectionName;
        mWebTitle = webTitle;
        mDate = date;
        mUrl = url;
    }

    public DateTime getmDate() {
        return mDate;
    }

    public String getmSectionName() {
        return mSectionName;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmWebTitle() {
        return mWebTitle;
    }
}
