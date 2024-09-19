package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Commit {
    @JsonProperty("author")
    private CommitAuthor author;

    @JsonProperty("committer")
    private CommitAuthor committer;

    @JsonProperty("message")
    private String message;

    @JsonProperty("tree")
    private Tree tree;

    @JsonProperty("url")
    private String url;

    @JsonProperty("comment_count")
    private int commentCount;

    @JsonProperty("verification")
    private Verification verification;

    public CommitAuthor getAuthor() {
        return author;
    }

    public void setAuthor(CommitAuthor author) {
        this.author = author;
    }

    public CommitAuthor getCommitter() {
        return committer;
    }

    public void setCommitter(CommitAuthor committer) {
        this.committer = committer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "author=" + author +
                ", committer=" + committer +
                ", message='" + message + '\'' +
                ", tree=" + tree +
                ", url='" + url + '\'' +
                ", commentCount=" + commentCount +
                ", verification=" + verification +
                '}';
    }
}
