package com.example.utils;

import com.example.model.PrivateUser;

public class TestContextHolder {

    PrivateUser privateUser = new PrivateUser();
    String githubToken = null;
    String userName = null;

    public PrivateUser getPrivateUser() {
        return privateUser;
    }

    public void setPrivateUser(PrivateUser privateUser) {
        this.privateUser = privateUser;
    }

    public String getGithubToken() {
        return githubToken;
    }

    public void setGithubToken(String githubToken) {
        this.githubToken = githubToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
