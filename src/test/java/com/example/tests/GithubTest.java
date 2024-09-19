package com.example.tests;

import com.example.models.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static com.example.tests.AssertUtils.assertFieldExistsAndCanBeNull;
import static org.junit.jupiter.api.Assertions.*;

public class GithubTest {

    private static final String BASE_USERS = "https://api.github.com/users";
    private static final String BASE_USER = "https://api.github.com/user";
    private static final String BASE_REPOS = "https://api.github.com/repos";
    private static final String accessToken = getTokenFromProperties();
    private static final String username = "/Jona283011";
    private static final String reponame = "/JonaAPITest";
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void task1() throws Exception {
        String url = BASE_USERS + username;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                String responseBody = EntityUtils.toString(response.getEntity());

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                PublicUser publicUser = objectMapper.readValue(responseBody, PublicUser.class);
                verifyPublicUser(publicUser);
            }
        }
    }

    @Test
    public void task2() throws Exception {
        String url = BASE_USER;
        String accessToken = "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";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.setHeader("Authorization", "Bearer " + accessToken);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                String responseBody = EntityUtils.toString(response.getEntity());

                objectMapper.registerModule(new JavaTimeModule());
                PrivateUser privateUser = objectMapper.readValue(responseBody, PrivateUser.class);
                verifyPrivateUser(privateUser);
            }
        }
    }

    @Test
    public void task3() throws Exception {
        String url = BASE_USERS + "/nonExistingUser";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_NOT_FOUND, statusCode, "Status code should be 404");
                String responseBody = EntityUtils.toString(response.getEntity());
                assertTrue(responseBody.contains("Not Found"), "Response body should contain 'Not Found'");
            }
        }
    }

    @Test
    public void task4() throws Exception {

        String url = BASE_USERS + username + "/repos";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                String responseBody = EntityUtils.toString(response.getEntity());
                try {
                    JSONArray jsonArray = new JSONArray(responseBody);

                    objectMapper.registerModule(new JavaTimeModule());
                    List<PublicRepo> publicRepositories = objectMapper.readValue(jsonArray.toString(), new TypeReference<List<PublicRepo>>(){});

                    boolean allVisibilityPublic = publicRepositories.stream()
                            .allMatch(repo -> "public".equals(repo.getVisibility()));

                    assertTrue(allVisibilityPublic, "All repositories should be public");
                    publicRepositories.forEach(this::verifyPublicRepo);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void task5() throws Exception {
        String url = BASE_USERS + "/TestingNonExistingUser" + "/repos";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_NOT_FOUND, statusCode, "Status code should be 404");
                String responseBody = EntityUtils.toString(response.getEntity());
                assertTrue(responseBody.contains("Not Found"), "Response body should contain 'Not Found'");
            }
        }
    }

    @Test
    public void task6() throws Exception {

        String url = BASE_USER + "/repos";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.setHeader("Authorization", "Token " + accessToken);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                String responseBody = EntityUtils.toString(response.getEntity());
                try {
                    JSONArray jsonArray = new JSONArray(responseBody);

                    objectMapper.registerModule(new JavaTimeModule());
                    List<PrivateRepo> privateRepositories = objectMapper.readValue(jsonArray.toString(), new TypeReference<List<PrivateRepo>>(){});

                    assertTrue(privateRepositories.stream().anyMatch(repo -> !repo.isPrivate()), "There must be at least one public repository");
                    assertTrue(privateRepositories.stream().anyMatch(repo -> repo.isPrivate()), "There must be at least one private repository");

                    privateRepositories.forEach(this::verifyPrivateRepo);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void task7() throws Exception {

        String url = BASE_REPOS + username +reponame+"/commits";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.setHeader("Authorization", "Bearer " + accessToken);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                String responseBody = EntityUtils.toString(response.getEntity());
                try {
                    JSONArray jsonArray = new JSONArray(responseBody);

                    objectMapper.registerModule(new JavaTimeModule());
                    List<CommitDetail> commitsList = objectMapper.readValue(jsonArray.toString(), new TypeReference<List<CommitDetail>>(){});

                    commitsList.forEach(this::verifyCommitsAndPrint);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void task8() throws Exception {
        String url = BASE_REPOS + "/nonExistingOwner/nonExistingRepo/commits";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_NOT_FOUND, statusCode, "Status code should be 404");
                String responseBody = EntityUtils.toString(response.getEntity());
                assertTrue(responseBody.contains("Not Found"), "Response body should contain 'Not Found'");
            }
        }
    }

    private void verifyPublicUser(PublicUser publicUser){
        assertNotNull(publicUser.getLogin(), "Login should not be null");
        assertNotNull(publicUser.getID(), "ID should be a positive integer");
        assertNotNull(publicUser.getNodeID(), "Node ID should not be null");
        assertNotNull(publicUser.getAvatarURL(), "Avatar URL should not be null");
        assertNotNull(publicUser.getURL(), "URL should not be null");
        assertNotNull(publicUser.getHTMLURL(), "HTML URL should not be null");
        assertNotNull(publicUser.getFollowersURL(), "Followers URL should not be null");
        assertNotNull(publicUser.getFollowingURL(), "Following URL should not be null");
        assertNotNull(publicUser.getGistsURL(), "Gists URL should not be null");
        assertNotNull(publicUser.getStarredURL(), "Starred URL should not be null");
        assertNotNull(publicUser.getSubscriptionsURL(), "Subscriptions URL should not be null");
        assertNotNull(publicUser.getOrganizationsURL(), "Organizations URL should not be null");
        assertNotNull(publicUser.getReposURL(), "Repos URL should not be null");
        assertNotNull(publicUser.getEventsURL(), "Events URL should not be null");
        assertNotNull(publicUser.getReceivedEventsURL(), "Received Events URL should not be null");
        assertNotNull(publicUser.getType(), "Type should not be null");
        assertNotNull(publicUser.getName(), "Name should not be null");
        assertNotNull(publicUser.getLocation(), "Location should not be null");
        assertNotNull(publicUser.getPublicRepos(), "Public Repos should not be null");
        assertNotNull(publicUser.getPublicGists(), "Public Gists should not be null");
        assertNotNull(publicUser.getFollowers(), "Followers should not be null");
        assertNotNull(publicUser.getFollowing(), "Following should not be null");
        assertNotNull(publicUser.getCreatedAt(), "Created At should not be null");
        assertNotNull(publicUser.getUpdatedAt(), "Updated At should not be null");
    }

    private void verifyPrivateUser(PrivateUser privateUser){
        assertNotNull(privateUser.getLogin(), "Login should not be null");
        assertNotNull(privateUser.getID() > 0, "ID should not be null");
        assertNotNull(privateUser.getNodeID(), "Node ID should not be null");
        assertNotNull(privateUser.getAvatarURL(), "Avatar URL should not be null");
        assertNotNull(privateUser.getGravatarID(), "Gravatar ID should not be null");
        assertNotNull(privateUser.getURL(), "URL should not be null");
        assertNotNull(privateUser.getHTMLURL(), "HTML URL should not be null");
        assertNotNull(privateUser.getFollowersURL(), "Followers URL should not be null");
        assertNotNull(privateUser.getFollowingURL(), "Following URL should not be null");
        assertNotNull(privateUser.getGistsURL(), "Gists URL should not be null");
        assertNotNull(privateUser.getStarredURL(), "Starred URL should not be null");
        assertNotNull(privateUser.getSubscriptionsURL(), "Subscriptions URL should not be null");
        assertNotNull(privateUser.getOrganizationsURL(), "Organizations URL should not be null");
        assertNotNull(privateUser.getReposURL(), "Repos URL should not be null");
        assertNotNull(privateUser.getEventsURL(), "Events URL should not be null");
        assertNotNull(privateUser.getReceivedEventsURL(), "Received Events URL should not be null");
        assertNotNull(privateUser.getType(), "Type should not be null");
        assertNotNull(privateUser.getSiteAdmin(), "Site Admin should not be null");
        assertNotNull(privateUser.getName(), "Name should not be null");
        assertNotNull(privateUser.getCompany(), "Company should not be null");
        assertNotNull(privateUser.getBlog(), "Blog should not be null");
        assertNotNull(privateUser.getLocation(), "Location should not be null");
        assertFieldExistsAndCanBeNull(privateUser.getEmail(), true);
        assertFieldExistsAndCanBeNull(privateUser.getHireable(), true);
        assertNotNull(privateUser.getBio(), "Bio should not be null");
        assertFieldExistsAndCanBeNull(privateUser.getTwitterUsername(), true);
        assertFieldExistsAndCanBeNull(privateUser.getNotificationEmail(), true);
        assertNotNull(privateUser.getPublicRepos(), "Public should not be null");
        assertNotNull(privateUser.getPublicGists(), "Public should not be null");
        assertNotNull(privateUser.getFollowers(), "Followers should not be null");
        assertNotNull(privateUser.getFollowing(), "Following should not be null");
        assertNotNull(privateUser.getCreatedAt(), "Created At should not be null");
        assertNotNull(privateUser.getUpdatedAt(), "Updated At should not be null");
        assertNotNull(privateUser.getPrivateGists(), "Private should not be null");
        assertNotNull(privateUser.getTotalPrivateRepos(), "Total should not be null");
        assertNotNull(privateUser.getOwnedPrivateRepos() , "Owned should not be null");
        assertNotNull(privateUser.getDiskUsage(), "Disk should not be null");
        assertNotNull(privateUser.getCollaborators(), "Collaborators should not be null");
        assertNotNull(privateUser.getTwoFactorAuthentication(), "Two Factor Authentication should not be null");

        // Verificar que el objeto Plan también está presente si es necesario
        assertNotNull(privateUser.getPlan(), "Plan should not be null");
        assertNotNull(privateUser.getPlan().getName(), "Plan name should not be null");
        assertNotNull(privateUser.getPlan().getSpace(), "Plan space should not be null");
        assertNotNull(privateUser.getPlan().getCollaborators(), "Plan collaborators should not be null");
        assertNotNull(privateUser.getPlan().getPrivateRepos(), "Plan private repos should not be null");
    }

    private void verifyPublicRepo(PublicRepo publicRepo){
        assertNotNull(publicRepo.getId(), "ID should not be null");
        assertNotNull(publicRepo.getNodeID(), "Node ID should not be null");
        assertNotNull(publicRepo.getName(), "Name should not be null");
        assertNotNull(publicRepo.getFullName(), "Full Name should not be null");
        assertNotNull(publicRepo.getOwner(), "Owner should not be null");
        assertNotNull(publicRepo.getHtmlURL(), "HTML URL should not be null");
        assertNotNull(publicRepo.getDescription(), "Description should not be null");
        assertNotNull(publicRepo.getUrl(), "URL should not be null");
        assertNotNull(publicRepo.getForksURL(), "Forks URL should not be null");
        assertNotNull(publicRepo.getKeysURL(), "Keys URL should not be null");
        assertNotNull(publicRepo.getCollaboratorsURL(), "Collaborators URL should not be null");
        assertNotNull(publicRepo.getTeamsURL(), "Teams URL should not be null");
        assertNotNull(publicRepo.getHooksURL(), "Hooks URL should not be null");
        assertNotNull(publicRepo.getIssueEventsURL(), "Issue Events URL should not be null");
        assertNotNull(publicRepo.getEventsURL(), "Events URL should not be null");
        assertNotNull(publicRepo.getAssigneesURL(), "Assignees URL should not be null");
        assertNotNull(publicRepo.getBranchesURL(), "Branches URL should not be null");
        assertNotNull(publicRepo.getTagsURL(), "Tags URL should not be null");
        assertNotNull(publicRepo.getBlobsURL(), "Blobs URL should not be null");
        assertNotNull(publicRepo.getGitTagsURL(), "Git Tags URL should not be null");
        assertNotNull(publicRepo.getGitRefsURL(), "Git Refs URL should not be null");
        assertNotNull(publicRepo.getTreesURL(), "Trees URL should not be null");
        assertNotNull(publicRepo.getStatusesURL(), "Statuses URL should not be null");
        assertNotNull(publicRepo.getLanguagesURL(), "Languages URL should not be null");
        assertNotNull(publicRepo.getStargazersURL(), "Stargazers URL should not be null");
        assertNotNull(publicRepo.getContributorsURL(), "Contributors URL should not be null");
        assertNotNull(publicRepo.getSubscribersURL(), "Subscribers URL should not be null");
        assertNotNull(publicRepo.getSubscriptionURL(), "Subscription URL should not be null");
        assertNotNull(publicRepo.getCommitsURL(), "Commits URL should not be null");
        assertNotNull(publicRepo.getGitCommitsURL(), "Git Commits URL should not be null");
        assertNotNull(publicRepo.getCommentsURL(), "Comments URL should not be null");
        assertNotNull(publicRepo.getIssueCommentURL(), "Issue Comment URL should not be null");
        assertNotNull(publicRepo.getContentsURL(), "Contents URL should not be null");
        assertNotNull(publicRepo.getCompareURL(), "Compare URL should not be null");
        assertNotNull(publicRepo.getMergesURL(), "Merges URL should not be null");
        assertNotNull(publicRepo.getArchiveURL(), "Archive URL should not be null");
        assertNotNull(publicRepo.getDownloadsURL(), "Downloads URL should not be null");
        assertNotNull(publicRepo.getIssuesURL(), "Issues URL should not be null");
        assertNotNull(publicRepo.getPullsURL(), "Pulls URL should not be null");
        assertNotNull(publicRepo.getMilestonesURL(), "Milestones URL should not be null");
        assertNotNull(publicRepo.getNotificationsURL(), "Notifications URL should not be null");
        assertNotNull(publicRepo.getLabelsURL(), "Labels URL should not be null");
        assertNotNull(publicRepo.getReleasesURL(), "Releases URL should not be null");
        assertNotNull(publicRepo.getDeploymentsURL(), "Deployments URL should not be null");
        assertNotNull(publicRepo.getCreatedAt(), "Created At should not be null");
        assertNotNull(publicRepo.getUpdatedAt(), "Updated At should not be null");
        assertNotNull(publicRepo.getPushedAt(), "Pushed At should not be null");
        assertNotNull(publicRepo.getGitURL(), "Git URL should not be null");
        assertNotNull(publicRepo.getSshURL(), "SSH URL should not be null");
        assertNotNull(publicRepo.getCloneURL(), "Clone URL should not be null");
        assertNotNull(publicRepo.getSvnURL(), "SVN URL should not be null");
        assertFieldExistsAndCanBeNull(publicRepo.getHomepage(), true);
        assertFieldExistsAndCanBeNull(publicRepo.getLanguage(), true);
        assertFieldExistsAndCanBeNull(publicRepo.getLicense(), true);
       // assertNotNull(publicRepo.getMirrorURL(), "Mirror URL should not be null");
        assertNotNull(publicRepo.getDefaultBranch(), "Default Branch should not be null");
    }

    private void verifyPrivateRepo(PrivateRepo privateRepo){
        assertNotNull(privateRepo.getId(), "ID should not be null");
        assertNotNull(privateRepo.getNodeID(), "Node ID should not be null");
        assertNotNull(privateRepo.getName(), "Name should not be null");
        assertNotNull(privateRepo.getFullName(), "Full Name should not be null");
        assertNotNull(privateRepo.getOwner(), "Owner should not be null");
        assertNotNull(privateRepo.getHtmlURL(), "HTML URL should not be null");
        assertFieldExistsAndCanBeNull(privateRepo.getDescription(), true);
        assertNotNull(privateRepo.getUrl(), "URL should not be null");
        assertNotNull(privateRepo.getForksURL(), "Forks URL should not be null");
        assertNotNull(privateRepo.getKeysURL(), "Keys URL should not be null");
        assertNotNull(privateRepo.getCollaboratorsURL(), "Collaborators URL should not be null");
        assertNotNull(privateRepo.getTeamsURL(), "Teams URL should not be null");
        assertNotNull(privateRepo.getHooksURL(), "Hooks URL should not be null");
        assertNotNull(privateRepo.getIssueEventsURL(), "Issue Events URL should not be null");
        assertNotNull(privateRepo.getEventsURL(), "Events URL should not be null");
        assertNotNull(privateRepo.getAssigneesURL(), "Assignees URL should not be null");
        assertNotNull(privateRepo.getBranchesURL(), "Branches URL should not be null");
        assertNotNull(privateRepo.getTagsURL(), "Tags URL should not be null");
        assertNotNull(privateRepo.getBlobsURL(), "Blobs URL should not be null");
        assertNotNull(privateRepo.getGitTagsURL(), "Git Tags URL should not be null");
        assertNotNull(privateRepo.getGitRefsURL(), "Git Refs URL should not be null");
        assertNotNull(privateRepo.getTreesURL(), "Trees URL should not be null");
        assertNotNull(privateRepo.getStatusesURL(), "Statuses URL should not be null");
        assertNotNull(privateRepo.getLanguagesURL(), "Languages URL should not be null");
        assertNotNull(privateRepo.getStargazersURL(), "Stargazers URL should not be null");
        assertNotNull(privateRepo.getContributorsURL(), "Contributors URL should not be null");
        assertNotNull(privateRepo.getSubscribersURL(), "Subscribers URL should not be null");
        assertNotNull(privateRepo.getSubscriptionURL(), "Subscription URL should not be null");
        assertNotNull(privateRepo.getCommitsURL(), "Commits URL should not be null");
        assertNotNull(privateRepo.getGitCommitsURL(), "Git Commits URL should not be null");
        assertNotNull(privateRepo.getCommentsURL(), "Comments URL should not be null");
        assertNotNull(privateRepo.getIssueCommentURL(), "Issue Comment URL should not be null");
        assertNotNull(privateRepo.getContentsURL(), "Contents URL should not be null");
        assertNotNull(privateRepo.getCompareURL(), "Compare URL should not be null");
        assertNotNull(privateRepo.getMergesURL(), "Merges URL should not be null");
        assertNotNull(privateRepo.getArchiveURL(), "Archive URL should not be null");
        assertNotNull(privateRepo.getDownloadsURL(), "Downloads URL should not be null");
        assertNotNull(privateRepo.getIssuesURL(), "Issues URL should not be null");
        assertNotNull(privateRepo.getPullsURL(), "Pulls URL should not be null");
        assertNotNull(privateRepo.getMilestonesURL(), "Milestones URL should not be null");
        assertNotNull(privateRepo.getNotificationsURL(), "Notifications URL should not be null");
        assertNotNull(privateRepo.getLabelsURL(), "Labels URL should not be null");
        assertNotNull(privateRepo.getReleasesURL(), "Releases URL should not be null");
        assertNotNull(privateRepo.getDeploymentsURL(), "Deployments URL should not be null");
        assertNotNull(privateRepo.getCreatedAt(), "Created At should not be null");
        assertNotNull(privateRepo.getUpdatedAt(), "Updated At should not be null");
        assertNotNull(privateRepo.getPushedAt(), "Pushed At should not be null");
        assertNotNull(privateRepo.getGitURL(), "Git URL should not be null");
        assertNotNull(privateRepo.getSshURL(), "SSH URL should not be null");
        assertNotNull(privateRepo.getCloneURL(), "Clone URL should not be null");
        assertNotNull(privateRepo.getSvnURL(), "SVN URL should not be null");
        assertFieldExistsAndCanBeNull(privateRepo.getHomepage(), true);
        assertFieldExistsAndCanBeNull(privateRepo.getLanguage(), true);
        assertFieldExistsAndCanBeNull(privateRepo.getLicense(), true);
        assertFieldExistsAndCanBeNull(privateRepo.getMirrorURL(), true);
        assertNotNull(privateRepo.getDefaultBranch(), "Default Branch should not be null");
        assertNotNull(privateRepo.getPermissions(), "Permissions should not be null");
    }

    private void verifyCommitsAndPrint(CommitDetail commitDetail){
        assertNotNull(commitDetail.getAuthor(), "Author should not be null");
        assertNotNull(commitDetail.getSha(), "Sha should not be null");
        assertNotNull(commitDetail.getCommit().getMessage(), "Message should not be null");
        System.out.println(commitDetail);
    }

    private static String getTokenFromProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config/config.properties")) {
            properties.load(input);
            return properties.getProperty("github.token");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
