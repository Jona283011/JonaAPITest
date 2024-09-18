package com.example.tests;

import com.example.models.PrivateRepo;
import com.example.models.PrivateUser;
import com.example.models.PublicUser;
import com.example.models.PublicRepo;
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

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GithubTest {

    private static final String BASE_USERS = "https://api.github.com/users";
    private static final String BASE_USER = "https://api.github.com/user";
    private static final String BASE_REPOS = "https://api.github.com/repos";
    private static final String accessToken = "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";
    private static final String username = "Jona283011";
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void task1() throws Exception {
        String url = BASE_USERS + username;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            //request.setHeader("Authorization", "token " + accessToken);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // Verificar el status code
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                // Leer la respuesta
                String responseBody = EntityUtils.toString(response.getEntity());

                // Verificar los campos de la respuesta
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
                // Verificar el status code
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                // Leer la respuesta
                String responseBody = EntityUtils.toString(response.getEntity());

                // Verificar los campos de la respuesta
                objectMapper.registerModule(new JavaTimeModule());
                PrivateUser privateUser = objectMapper.readValue(responseBody, PrivateUser.class);
                verifyPrivateUser(privateUser);
            }
        }
    }

    @Test
    public void task3() throws Exception {
        String url = BASE_USERS + "nonExistingUser";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // Verificar el status code
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
            request.setHeader("Authorization", "Token " + accessToken);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // Verificar el status code
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                // Leer la respuesta
                String responseBody = EntityUtils.toString(response.getEntity());
                try {
                    // Parsear la respuesta JSON
                    JSONArray jsonArray = new JSONArray(responseBody);

                    // Convertir JSON a objetos Repository
                    objectMapper.registerModule(new JavaTimeModule());
                    List<PublicRepo> publicRepositories = objectMapper.readValue(jsonArray.toString(), new TypeReference<List<PublicRepo>>(){});

                    // Validar que el campo 'visibility' sea 'public' en todos los objetos Repository
                    boolean allVisibilityPublic = publicRepositories.stream()
                            .allMatch(repo -> "public".equals(repo.getVisibility()));

                    assertTrue(allVisibilityPublic, "All repositories should be public");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void task5() throws Exception {
        String url = BASE_USERS + "TestingNonExistingUser" + "/repos";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // Verificar el status code
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
                // Verificar el status code
                int statusCode = response.getStatusLine().getStatusCode();
                assertEquals(HttpStatus.SC_OK, statusCode, "Status code should be 200");

                // Leer la respuesta
                String responseBody = EntityUtils.toString(response.getEntity());
                try {
                    // Parsear la respuesta JSON
                    JSONArray jsonArray = new JSONArray(responseBody);

                    // Convertir JSON a objetos Repository
                    objectMapper.registerModule(new JavaTimeModule());
                    List<PrivateRepo> privateRepositories = objectMapper.readValue(jsonArray.toString(), new TypeReference<List<PrivateRepo>>(){});

                    // Verificar que haya al menos un repositorio privado y uno público

                    assertTrue(privateRepositories.stream().anyMatch(repo -> !repo.isPrivate()), "There must be at least one public repository");
                    assertTrue(privateRepositories.stream().anyMatch(repo -> repo.isPrivate()), "There must be at least one private repository");

                } catch (IOException e) {
                    e.printStackTrace();
                }
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
       // assertNotNull(privateUser.getEmail(), "Email field should be present in the response");
        //assertNotNull(privateUser.getHireable(), "Hireable should not be null");
        assertNotNull(privateUser.getBio(), "Bio should not be null");
        //assertNotNull(privateUser.getTwitterUsername(), "Twitter Username should not be null");
        //assertNotNull(privateUser.getNotificationEmail(), "Notification Email should not be null");
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
}
