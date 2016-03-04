package com.kunyan.htmlparse.strategyPattern;

/**
 * Created by make on 2/29/16.
 */
public class NewsItem {
    private String title = null;
    private String content = null;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private long timeStamp = 0L;


    public NewsItem(String content, long timeStamp, String title) {
        this.content = content;
        this.timeStamp = timeStamp;
        this.title = title;
    }




}
