package com.example.jette.helloworld.com.example.jette.helloworld.model;

public class Entry {

    private String url;
    private int id;
    private String[] upvotes;
    private String[] downvotes;
    private int score;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String[] upvotes) {
        this.upvotes = upvotes;
    }

    public String[] getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(String[] downvotes) {
        this.downvotes = downvotes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
