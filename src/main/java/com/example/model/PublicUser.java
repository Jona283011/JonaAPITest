package com.example.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PublicUser {
    @NotNull
    @JsonProperty("login")
    private String login;

    @NotNull
    @JsonProperty("id")
    private long id;

    @NotNull
    @JsonProperty("node_id")
    private String nodeID;

    @NotNull
    @Pattern(regexp = "^https?://.*", message = "Should be a valid URL")
    @JsonProperty("avatar_url")
    private String avatarURL;

    @JsonInclude
    @JsonProperty("gravatar_id")
    private String gravatarID;

    @NotNull
    @Pattern(regexp = "^https?://.*", message = "Should be a valid URL")
    @JsonProperty("url")
    private String url;

    @NotNull
    @Pattern(regexp = "^https?://.*", message = "Should be a valid URL")
    @JsonProperty("html_url")
    private String htmlURL;

    @NotNull
    @Pattern(regexp = "^https?://.*", message = "Should be a valid URL")
    @JsonProperty("followers_url")
    private String followersURL;

    @NotNull
    @JsonProperty("following_url")
    private String followingURL;

    @NotNull
    @JsonProperty("gists_url")
    private String gistsURL;

    @NotNull
    @JsonProperty("starred_url")
    private String starredURL;

    @NotNull
    @Pattern(regexp = "^https?://.*", message = "Should be a valid URL")
    @JsonProperty("subscriptions_url")
    private String subscriptionsURL;

    @NotNull
    @Pattern(regexp = "^https?://.*", message = "Should be a valid URL")
    @JsonProperty("organizations_url")
    private String organizationsURL;

    @NotNull
    @Pattern(regexp = "^https?://.*", message = "Should be a valid URL")
    @JsonProperty("repos_url")
    private String reposURL;

    @NotNull
    @JsonProperty("events_url")
    private String eventsURL;

    @NotNull
    @Pattern(regexp = "^https?://.*", message = "Should be a valid URL")
    @JsonProperty("received_events_url")
    private String receivedEventsURL;

    @NotNull
    @JsonProperty("type")
    private String type;

    @NotNull
    @JsonProperty("site_admin")
    private boolean siteAdmin;

    @JsonInclude
    @JsonProperty("name")
    private String name;

    @JsonInclude
    @JsonProperty("company")
    private String company;

    @JsonInclude
    @JsonProperty("blog")
    private String blog;

    @JsonInclude
    @JsonProperty("location")
    private String location;

    @JsonInclude
    @Email
    @JsonProperty("email")
    private String email;

    @JsonInclude
    @JsonProperty("hireable")
    private Boolean hireable;

    @JsonInclude
    @JsonProperty("bio")
    private String bio;

    @JsonInclude
    @JsonProperty("twitter_username")
    private String twitterUsername;

    @NotNull
    @JsonProperty("public_repos")
    private int publicRepos;

    @NotNull
    @JsonProperty("public_gists")
    private int publicGists;

    @NotNull
    @JsonProperty("followers")
    private int followers;

    @NotNull
    @JsonProperty("following")
    private int following;

    @NotNull
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @NotNull
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    public String getLogin() { return login; }
    public void setLogin(String value) { this.login = value; }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getNodeID() { return nodeID; }
    public void setNodeID(String value) { this.nodeID = value; }

    public String getAvatarURL() { return avatarURL; }
    public void setAvatarURL(String value) { this.avatarURL = value; }

    public String getGravatarID() { return gravatarID; }
    public void setGravatarID(String value) { this.gravatarID = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public String getHTMLURL() { return htmlURL; }
    public void setHTMLURL(String value) { this.htmlURL = value; }

    public String getFollowersURL() { return followersURL; }
    public void setFollowersURL(String value) { this.followersURL = value; }

    public String getFollowingURL() { return followingURL; }
    public void setFollowingURL(String value) { this.followingURL = value; }

    public String getGistsURL() { return gistsURL; }
    public void setGistsURL(String value) { this.gistsURL = value; }

    public String getStarredURL() { return starredURL; }
    public void setStarredURL(String value) { this.starredURL = value; }

    public String getSubscriptionsURL() { return subscriptionsURL; }
    public void setSubscriptionsURL(String value) { this.subscriptionsURL = value; }

    public String getOrganizationsURL() { return organizationsURL; }
    public void setOrganizationsURL(String value) { this.organizationsURL = value; }

    public String getReposURL() { return reposURL; }
    public void setReposURL(String value) { this.reposURL = value; }

    public String getEventsURL() { return eventsURL; }
    public void setEventsURL(String value) { this.eventsURL = value; }

    public String getReceivedEventsURL() { return receivedEventsURL; }
    public void setReceivedEventsURL(String value) { this.receivedEventsURL = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public boolean getSiteAdmin() { return siteAdmin; }
    public void setSiteAdmin(boolean value) { this.siteAdmin = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getCompany() { return company; }
    public void setCompany(String value) { this.company = value; }

    public String getBlog() { return blog; }
    public void setBlog(String value) { this.blog = value; }

    public String getLocation() { return location; }
    public void setLocation(String value) { this.location = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public Boolean getHireable() { return hireable; }
    public void setHireable(Boolean value) { this.hireable = value; }

    public String getBio() { return bio; }
    public void setBio(String value) { this.bio = value; }

    public String getTwitterUsername() { return twitterUsername; }
    public void setTwitterUsername(String value) { this.twitterUsername = value; }

    public int getPublicRepos() { return publicRepos; }
    public void setPublicRepos(int value) { this.publicRepos = value; }

    public int getPublicGists() { return publicGists; }
    public void setPublicGists(int value) { this.publicGists = value; }

    public int getFollowers() { return followers; }
    public void setFollowers(int value) { this.followers = value; }

    public int getFollowing() { return following; }
    public void setFollowing(int value) { this.following = value; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime value) { this.createdAt = value; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime value) { this.updatedAt = value; }
}

