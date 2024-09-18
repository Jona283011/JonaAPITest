package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Owner {

    @JsonProperty("login")
    private String login;

    @JsonProperty("id")
    private long id;

    @JsonProperty("node_id")
    private String nodeID;

    @JsonProperty("avatar_url")
    private String avatarURL;

    @JsonProperty("gravatar_id")
    private String gravatarID;

    @JsonProperty("url")
    private String url;

    @JsonProperty("html_url")
    private String htmlURL;

    @JsonProperty("followers_url")
    private String followersURL;

    @JsonProperty("following_url")
    private String followingURL;

    @JsonProperty("gists_url")
    private String gistsURL;

    @JsonProperty("starred_url")
    private String starredURL;

    @JsonProperty("subscriptions_url")
    private String subscriptionsURL;

    @JsonProperty("organizations_url")
    private String organizationsURL;

    @JsonProperty("repos_url")
    private String reposURL;

    @JsonProperty("events_url")
    private String eventsURL;

    @JsonProperty("received_events_url")
    private String receivedEventsURL;

    @JsonProperty("type")
    private String type;

    @JsonProperty("site_admin")
    private boolean siteAdmin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getGravatarID() {
        return gravatarID;
    }

    public void setGravatarID(String gravatarID) {
        this.gravatarID = gravatarID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlURL() {
        return htmlURL;
    }

    public void setHtmlURL(String htmlURL) {
        this.htmlURL = htmlURL;
    }

    public String getFollowersURL() {
        return followersURL;
    }

    public void setFollowersURL(String followersURL) {
        this.followersURL = followersURL;
    }

    public String getFollowingURL() {
        return followingURL;
    }

    public void setFollowingURL(String followingURL) {
        this.followingURL = followingURL;
    }

    public String getGistsURL() {
        return gistsURL;
    }

    public void setGistsURL(String gistsURL) {
        this.gistsURL = gistsURL;
    }

    public String getStarredURL() {
        return starredURL;
    }

    public void setStarredURL(String starredURL) {
        this.starredURL = starredURL;
    }

    public String getSubscriptionsURL() {
        return subscriptionsURL;
    }

    public void setSubscriptionsURL(String subscriptionsURL) {
        this.subscriptionsURL = subscriptionsURL;
    }

    public String getOrganizationsURL() {
        return organizationsURL;
    }

    public void setOrganizationsURL(String organizationsURL) {
        this.organizationsURL = organizationsURL;
    }

    public String getReposURL() {
        return reposURL;
    }

    public void setReposURL(String reposURL) {
        this.reposURL = reposURL;
    }

    public String getEventsURL() {
        return eventsURL;
    }

    public void setEventsURL(String eventsURL) {
        this.eventsURL = eventsURL;
    }

    public String getReceivedEventsURL() {
        return receivedEventsURL;
    }

    public void setReceivedEventsURL(String receivedEventsURL) {
        this.receivedEventsURL = receivedEventsURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }
}

