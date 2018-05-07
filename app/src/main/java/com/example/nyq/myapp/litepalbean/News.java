package com.example.nyq.myapp.litepalbean;

import java.sql.Date;

/**
 * Created by nyq on 2018/5/7.
 */

public class News {
    private String title;
    private String content;
    private Date publisDate;
    private int commentCount;

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

    public Date getPublisDate() {
        return publisDate;
    }

    public void setPublisDate(Date publisDate) {
        this.publisDate = publisDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
