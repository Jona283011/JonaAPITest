package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;

public class PublicRepo {

    @JsonProperty("id")
    private long id;

    @JsonProperty("node_id")
    private String nodeID;

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("private")
    private boolean isPrivate;

    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("html_url")
    private String htmlURL;

    @JsonProperty("description")
    private String description;

    @JsonProperty("fork")
    private boolean fork;

    @JsonProperty("url")
    private String url;

    @JsonProperty("forks_url")
    private String forksURL;

    @JsonProperty("keys_url")
    private String keysURL;

    @JsonProperty("collaborators_url")
    private String collaboratorsURL;

    @JsonProperty("teams_url")
    private String teamsURL;

    @JsonProperty("hooks_url")
    private String hooksURL;

    @JsonProperty("issue_events_url")
    private String issueEventsURL;

    @JsonProperty("events_url")
    private String eventsURL;

    @JsonProperty("assignees_url")
    private String assigneesURL;

    @JsonProperty("branches_url")
    private String branchesURL;

    @JsonProperty("tags_url")
    private String tagsURL;

    @JsonProperty("blobs_url")
    private String blobsURL;

    @JsonProperty("git_tags_url")
    private String gitTagsURL;

    @JsonProperty("git_refs_url")
    private String gitRefsURL;

    @JsonProperty("trees_url")
    private String treesURL;

    @JsonProperty("statuses_url")
    private String statusesURL;

    @JsonProperty("languages_url")
    private String languagesURL;

    @JsonProperty("stargazers_url")
    private String stargazersURL;

    @JsonProperty("contributors_url")
    private String contributorsURL;

    @JsonProperty("subscribers_url")
    private String subscribersURL;

    @JsonProperty("subscription_url")
    private String subscriptionURL;

    @JsonProperty("commits_url")
    private String commitsURL;

    @JsonProperty("git_commits_url")
    private String gitCommitsURL;

    @JsonProperty("comments_url")
    private String commentsURL;

    @JsonProperty("issue_comment_url")
    private String issueCommentURL;

    @JsonProperty("contents_url")
    private String contentsURL;

    @JsonProperty("compare_url")
    private String compareURL;

    @JsonProperty("merges_url")
    private String mergesURL;

    @JsonProperty("archive_url")
    private String archiveURL;

    @JsonProperty("downloads_url")
    private String downloadsURL;

    @JsonProperty("issues_url")
    private String issuesURL;

    @JsonProperty("pulls_url")
    private String pullsURL;

    @JsonProperty("milestones_url")
    private String milestonesURL;

    @JsonProperty("notifications_url")
    private String notificationsURL;

    @JsonProperty("labels_url")
    private String labelsURL;

    @JsonProperty("releases_url")
    private String releasesURL;

    @JsonProperty("deployments_url")
    private String deploymentsURL;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    @JsonProperty("pushed_at")
    private OffsetDateTime pushedAt;

    @JsonProperty("git_url")
    private String gitURL;

    @JsonProperty("ssh_url")
    private String sshURL;

    @JsonProperty("clone_url")
    private String cloneURL;

    @JsonProperty("svn_url")
    private String svnURL;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("size")
    private int size;

    @JsonProperty("stargazers_count")
    private int stargazersCount;

    @JsonProperty("watchers_count")
    private int watchersCount;

    @JsonProperty("language")
    private String language;

    @JsonProperty("has_issues")
    private boolean hasIssues;

    @JsonProperty("has_projects")
    private boolean hasProjects;

    @JsonProperty("has_downloads")
    private boolean hasDownloads;

    @JsonProperty("has_wiki")
    private boolean hasWiki;

    @JsonProperty("has_pages")
    private boolean hasPages;

    @JsonProperty("has_discussions")
    private boolean hasDiscussions;

    @JsonProperty("forks_count")
    private int forksCount;

    @JsonProperty("mirror_url")
    private String mirrorURL;

    @JsonProperty("archived")
    private boolean archived;

    @JsonProperty("disabled")
    private boolean disabled;

    @JsonProperty("open_issues_count")
    private int openIssuesCount;

    @JsonProperty("license")
    private String license;

    @JsonProperty("allow_forking")
    private boolean allowForking;

    @JsonProperty("is_template")
    private boolean isTemplate;

    @JsonProperty("web_commit_signoff_required")
    private boolean webCommitSignoffRequired;

    @JsonProperty("topics")
    private List<String> topics;

    @JsonProperty("visibility")
    private String visibility;

    @JsonProperty("forks")
    private int forks;

    @JsonProperty("open_issues")
    private int openIssues;

    @JsonProperty("watchers")
    private int watchers;

    @JsonProperty("default_branch")
    private String defaultBranch;

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public boolean isWebCommitSignoffRequired() {
        return webCommitSignoffRequired;
    }

    public void setWebCommitSignoffRequired(boolean webCommitSignoffRequired) {
        this.webCommitSignoffRequired = webCommitSignoffRequired;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public boolean isAllowForking() {
        return allowForking;
    }

    public void setAllowForking(boolean allowForking) {
        this.allowForking = allowForking;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getMirrorURL() {
        return mirrorURL;
    }

    public void setMirrorURL(String mirrorURL) {
        this.mirrorURL = mirrorURL;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public boolean isHasDiscussions() {
        return hasDiscussions;
    }

    public void setHasDiscussions(boolean hasDiscussions) {
        this.hasDiscussions = hasDiscussions;
    }

    public boolean isHasPages() {
        return hasPages;
    }

    public void setHasPages(boolean hasPages) {
        this.hasPages = hasPages;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public boolean isHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    public boolean isHasProjects() {
        return hasProjects;
    }

    public void setHasProjects(boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    public boolean isHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(int watchersCount) {
        this.watchersCount = watchersCount;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getSvnURL() {
        return svnURL;
    }

    public void setSvnURL(String svnURL) {
        this.svnURL = svnURL;
    }

    public String getCloneURL() {
        return cloneURL;
    }

    public void setCloneURL(String cloneURL) {
        this.cloneURL = cloneURL;
    }

    public String getSshURL() {
        return sshURL;
    }

    public void setSshURL(String sshURL) {
        this.sshURL = sshURL;
    }

    public String getGitURL() {
        return gitURL;
    }

    public void setGitURL(String gitURL) {
        this.gitURL = gitURL;
    }

    public OffsetDateTime getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(OffsetDateTime pushedAt) {
        this.pushedAt = pushedAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeploymentsURL() {
        return deploymentsURL;
    }

    public void setDeploymentsURL(String deploymentsURL) {
        this.deploymentsURL = deploymentsURL;
    }

    public String getReleasesURL() {
        return releasesURL;
    }

    public void setReleasesURL(String releasesURL) {
        this.releasesURL = releasesURL;
    }

    public String getLabelsURL() {
        return labelsURL;
    }

    public void setLabelsURL(String labelsURL) {
        this.labelsURL = labelsURL;
    }

    public String getNotificationsURL() {
        return notificationsURL;
    }

    public void setNotificationsURL(String notificationsURL) {
        this.notificationsURL = notificationsURL;
    }

    public String getMilestonesURL() {
        return milestonesURL;
    }

    public void setMilestonesURL(String milestonesURL) {
        this.milestonesURL = milestonesURL;
    }

    public String getPullsURL() {
        return pullsURL;
    }

    public void setPullsURL(String pullsURL) {
        this.pullsURL = pullsURL;
    }

    public String getIssuesURL() {
        return issuesURL;
    }

    public void setIssuesURL(String issuesURL) {
        this.issuesURL = issuesURL;
    }

    public String getDownloadsURL() {
        return downloadsURL;
    }

    public void setDownloadsURL(String downloadsURL) {
        this.downloadsURL = downloadsURL;
    }

    public String getArchiveURL() {
        return archiveURL;
    }

    public void setArchiveURL(String archiveURL) {
        this.archiveURL = archiveURL;
    }

    public String getMergesURL() {
        return mergesURL;
    }

    public void setMergesURL(String mergesURL) {
        this.mergesURL = mergesURL;
    }

    public String getCompareURL() {
        return compareURL;
    }

    public void setCompareURL(String compareURL) {
        this.compareURL = compareURL;
    }

    public String getContentsURL() {
        return contentsURL;
    }

    public void setContentsURL(String contentsURL) {
        this.contentsURL = contentsURL;
    }

    public String getIssueCommentURL() {
        return issueCommentURL;
    }

    public void setIssueCommentURL(String issueCommentURL) {
        this.issueCommentURL = issueCommentURL;
    }

    public String getCommentsURL() {
        return commentsURL;
    }

    public void setCommentsURL(String commentsURL) {
        this.commentsURL = commentsURL;
    }

    public String getGitCommitsURL() {
        return gitCommitsURL;
    }

    public void setGitCommitsURL(String gitCommitsURL) {
        this.gitCommitsURL = gitCommitsURL;
    }

    public String getCommitsURL() {
        return commitsURL;
    }

    public void setCommitsURL(String commitsURL) {
        this.commitsURL = commitsURL;
    }

    public String getSubscriptionURL() {
        return subscriptionURL;
    }

    public void setSubscriptionURL(String subscriptionURL) {
        this.subscriptionURL = subscriptionURL;
    }

    public String getSubscribersURL() {
        return subscribersURL;
    }

    public void setSubscribersURL(String subscribersURL) {
        this.subscribersURL = subscribersURL;
    }

    public String getContributorsURL() {
        return contributorsURL;
    }

    public void setContributorsURL(String contributorsURL) {
        this.contributorsURL = contributorsURL;
    }

    public String getStargazersURL() {
        return stargazersURL;
    }

    public void setStargazersURL(String stargazersURL) {
        this.stargazersURL = stargazersURL;
    }

    public String getLanguagesURL() {
        return languagesURL;
    }

    public void setLanguagesURL(String languagesURL) {
        this.languagesURL = languagesURL;
    }

    public String getStatusesURL() {
        return statusesURL;
    }

    public void setStatusesURL(String statusesURL) {
        this.statusesURL = statusesURL;
    }

    public String getTreesURL() {
        return treesURL;
    }

    public void setTreesURL(String treesURL) {
        this.treesURL = treesURL;
    }

    public String getGitRefsURL() {
        return gitRefsURL;
    }

    public void setGitRefsURL(String gitRefsURL) {
        this.gitRefsURL = gitRefsURL;
    }

    public String getGitTagsURL() {
        return gitTagsURL;
    }

    public void setGitTagsURL(String gitTagsURL) {
        this.gitTagsURL = gitTagsURL;
    }

    public String getBlobsURL() {
        return blobsURL;
    }

    public void setBlobsURL(String blobsURL) {
        this.blobsURL = blobsURL;
    }

    public String getTagsURL() {
        return tagsURL;
    }

    public void setTagsURL(String tagsURL) {
        this.tagsURL = tagsURL;
    }

    public String getBranchesURL() {
        return branchesURL;
    }

    public void setBranchesURL(String branchesURL) {
        this.branchesURL = branchesURL;
    }

    public String getAssigneesURL() {
        return assigneesURL;
    }

    public void setAssigneesURL(String assigneesURL) {
        this.assigneesURL = assigneesURL;
    }

    public String getEventsURL() {
        return eventsURL;
    }

    public void setEventsURL(String eventsURL) {
        this.eventsURL = eventsURL;
    }

    public String getIssueEventsURL() {
        return issueEventsURL;
    }

    public void setIssueEventsURL(String issueEventsURL) {
        this.issueEventsURL = issueEventsURL;
    }

    public String getHooksURL() {
        return hooksURL;
    }

    public void setHooksURL(String hooksURL) {
        this.hooksURL = hooksURL;
    }

    public String getTeamsURL() {
        return teamsURL;
    }

    public void setTeamsURL(String teamsURL) {
        this.teamsURL = teamsURL;
    }

    public String getCollaboratorsURL() {
        return collaboratorsURL;
    }

    public void setCollaboratorsURL(String collaboratorsURL) {
        this.collaboratorsURL = collaboratorsURL;
    }

    public String getKeysURL() {
        return keysURL;
    }

    public void setKeysURL(String keysURL) {
        this.keysURL = keysURL;
    }

    public String getForksURL() {
        return forksURL;
    }

    public void setForksURL(String forksURL) {
        this.forksURL = forksURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtmlURL() {
        return htmlURL;
    }

    public void setHtmlURL(String htmlURL) {
        this.htmlURL = htmlURL;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
