package com.example.model.controllers;

import com.example.model.PrivateUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserController {

    private final String BASEUrl = "https://api.github.com/";
    ObjectMapper objectMapper = new ObjectMapper();

    public PrivateUser getUserEndpoint(String githubToken) throws JsonProcessingException {
        String url = BASEUrl+"user";

        Response response = RestAssured
                .given()
                .baseUri(url)
                .header("Authorization", "Bearer " +getTokenFromProperties(githubToken))
                .when()
                .get()
                .then()
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        assertEquals(response.statusCode(), HttpStatus.SC_OK, "StatusCode should be:"+ HttpStatus.SC_OK);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(responseBody, PrivateUser.class);
    }

    public PrivateUser getUserEndpoint(String githubToken, int expectedStatusCode) throws JsonProcessingException {
        String url = BASEUrl+"user";

        Response response = RestAssured
                .given()
                .baseUri(url)
                .header("Authorization", "Bearer " +getTokenFromProperties(githubToken))
                .when()
                .get()
                .then()
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        assertEquals(response.statusCode(), expectedStatusCode, "StatusCode should be: "+ expectedStatusCode);
        objectMapper.registerModule(new JavaTimeModule());
        if(expectedStatusCode != HttpStatus.SC_OK) {
            return null;
        }else{
            return objectMapper.readValue(responseBody, PrivateUser.class);
        }
    }

    public PrivateUser getUserByUsernameEndpoint(String githubToken, String userName) throws JsonProcessingException {
        String url = BASEUrl+"users/"+userName;

        Response response = RestAssured
                .given()
                .baseUri(url)
                .header("Authorization", "Bearer " +getTokenFromProperties(githubToken))
                .when()
                .get()
                .then()
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        assertEquals(response.statusCode(), HttpStatus.SC_OK, "StatusCode should be:"+ HttpStatus.SC_OK);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(responseBody, PrivateUser.class);
    }

    public PrivateUser getUserByUsernameEndpoint(int expectedStatusCode, String expectedMessage, String userName) throws JsonProcessingException {
        String url = BASEUrl+"users/"+userName;

        Response response = RestAssured
                .given()
                .baseUri(url)
                .when()
                .get()
                .then()
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        assertEquals(response.statusCode(), expectedStatusCode, "StatusCode should be:"+ expectedStatusCode);
        assertTrue(response.statusLine().contains(expectedMessage), "Response body should contain: "+expectedMessage);
        objectMapper.registerModule(new JavaTimeModule());
        if(expectedStatusCode != HttpStatus.SC_OK) {
            return null;
        }else{
            return objectMapper.readValue(responseBody, PrivateUser.class);
        }
    }

    public PrivateUser patchUserEndpoint(String githubToken, String requestBody) throws JsonProcessingException {
        String url = BASEUrl+"user";

        Response response = RestAssured
                .given()
                .baseUri(url)
                .header("Authorization", "Bearer " +getTokenFromProperties(githubToken))
                .body(requestBody)
                .when()
                .patch()
                .then()
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        assertEquals(response.statusCode(), HttpStatus.SC_OK, "StatusCode should be:"+ HttpStatus.SC_OK);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(responseBody, PrivateUser.class);
    }

    public PrivateUser patchUserEndpoint(String githubToken, String requestBody, int expectedStatusCode) throws JsonProcessingException {
        String url = BASEUrl+"user";

        Response response = RestAssured
                .given()
                .baseUri(url)
                .header("Authorization", "Bearer " +getTokenFromProperties(githubToken))
                .body(requestBody)
                .when()
                .patch()
                .then()
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        assertEquals(response.statusCode(), expectedStatusCode, "StatusCode should be:"+ expectedStatusCode);
        objectMapper.registerModule(new JavaTimeModule());
        if(expectedStatusCode != HttpStatus.SC_OK) {
            return null;
        }else{
            return objectMapper.readValue(responseBody, PrivateUser.class);
        }
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
