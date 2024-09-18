package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tree {
    @JsonProperty("sha")
    private String sha;

    @JsonProperty("url")
    private String url;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "sha='" + sha + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

