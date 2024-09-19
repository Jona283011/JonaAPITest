package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class CommitDetail {
    @JsonProperty("sha")
    private String sha;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("commit")
    private Commit commit;

    @JsonProperty("url")
    private String url;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("comments_url")
    private String commentsUrl;

    @JsonProperty("author")
    private User author;

    @JsonProperty("committer")
    private User committer;

    @JsonProperty("parents")
    private Parent[] parents;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getCommitter() {
        return committer;
    }

    public void setCommitter(User committer) {
        this.committer = committer;
    }

    public Parent[] getParents() {
        return parents;
    }

    public void setParents(Parent[] parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "CommitDetail{" +
                "sha='" + sha + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", commit=" + commit +
                ", url='" + url + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", commentsUrl='" + commentsUrl + '\'' +
                ", author=" + author +
                ", committer=" + committer +
                ", parents=" + Arrays.toString(parents) +
                '}';
    }
}

