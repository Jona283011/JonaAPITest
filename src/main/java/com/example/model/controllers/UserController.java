package com.example.model.controllers;

import com.example.model.PrivateUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserController {

    private final String BaseUrl = "https://api.github.com/";
    ObjectMapper objectMapper = new ObjectMapper();

    public UserController() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public PrivateUser getUserEndpoint(String githubToken) throws JsonProcessingException {
        String url = BaseUrl + "user";
        Response response = sendGetRequest(url, githubToken);
        validateResponse(response, HttpStatus.SC_OK, null);
        return deserializeResponse(response, HttpStatus.SC_OK);
    }

    public PrivateUser getUserEndpoint(String githubToken, int expectedStatusCode) throws JsonProcessingException {
        String url = BaseUrl + "user";
        Response response = sendGetRequest(url, githubToken);
        validateResponse(response, expectedStatusCode, null);
        return deserializeResponse(response, expectedStatusCode);
    }

    public PrivateUser getUserByUsernameEndpoint(int expectedStatusCode, String expectedMessage, String userName) throws JsonProcessingException {
        String url = BaseUrl + "users/" + userName;
        Response response = sendGetRequest(url, null);
        validateResponse(response, expectedStatusCode, expectedMessage);
        return deserializeResponse(response, expectedStatusCode);
    }

    public PrivateUser patchUserEndpoint(String githubToken, String requestBody) throws JsonProcessingException {
        String url = BaseUrl + "user";
        Response response = sendPatchRequest(url, githubToken, requestBody);
        validateResponse(response, HttpStatus.SC_OK);
        return deserializeResponse(response, HttpStatus.SC_OK);
    }

    public PrivateUser patchUserEndpoint(String githubToken, String requestBody, int expectedStatusCode) throws JsonProcessingException {
        String url = BaseUrl + "user";
        Response response = sendPatchRequest(url, githubToken, requestBody);
        validateResponse(response, expectedStatusCode);
        return deserializeResponse(response, expectedStatusCode);
    }

    private Response sendGetRequest(String url, String githubToken) {
        RequestSpecification request = RestAssured.given().baseUri(url);
        if (githubToken != null && !githubToken.isEmpty()) {
            request.header("Authorization", "Bearer " + getTokenFromProperties(githubToken));
        }
        return request.when().get().then().extract().response();
    }

    private void validateResponse(Response response, int expectedStatusCode, String expectedMessage) {
        assertEquals(response.statusCode(), expectedStatusCode, "StatusCode should be: " + expectedStatusCode);
        if (expectedMessage != null) {
            assertTrue(response.statusLine().contains(expectedMessage), "Response should contain: " + expectedMessage);
        }
    }

    private void validateResponse(Response response, int expectedStatusCode) {
        assertEquals(response.statusCode(), expectedStatusCode, "StatusCode should be: " + expectedStatusCode);
    }

    private PrivateUser deserializeResponse(Response response, int expectedStatusCode) throws JsonProcessingException {
        if (expectedStatusCode != HttpStatus.SC_OK) {
            return null;
        }
        return objectMapper.readValue(response.getBody().asString(), PrivateUser.class);
    }

    private Response sendPatchRequest(String url, String githubToken, String requestBody) {
        return RestAssured
                .given()
                .baseUri(url)
                .header("Authorization", "Bearer " + getTokenFromProperties(githubToken))
                .body(requestBody)
                .when()
                .patch()
                .then()
                .extract()
                .response();
    }


    private static String getTokenFromProperties(String githubToken) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config/config.properties")) {
            properties.load(input);
            return properties.getProperty(githubToken);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
