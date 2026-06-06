package com.cookandroid.share_platform;

public class Post {
    private String title;
    private String content;
    private String author;
    private String timestamp;
    private int commentCount;
    private int scrapCount;

    public Post(String title, String content, String author, String timestamp, int commentCount, int scrapCount) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
        this.commentCount = commentCount;
        this.scrapCount = scrapCount;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
    public String getTimestamp() { return timestamp; }
    public int getCommentCount() { return commentCount; }
    public int getScrapCount() { return scrapCount; }
}