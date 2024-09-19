package com.example.steps;

import com.example.model.controllers.UserController;
import com.example.utils.TestContextHolder;
import com.example.utils.TestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static com.example.utils.TestUtils.getContext;
import static org.testng.Assert.*;

public class UserSteps {

    UserController userController = new UserController();
    private String jsonPayload;

    @Given("Default user without github token")
    public void createAuthenticationRequest() {
        TestUtils.contextHolder.set(new TestContextHolder());
    }

    @Given("Default user with github token {string}")
    public void createAuthenticationRequest(String githubToken) {
        TestUtils.contextHolder.set(new TestContextHolder());
        getContext().setGithubToken(githubToken);
    }

    @Given("Default user with username {string}")
    public void createAuthenticationRequest2(String username) {
        TestUtils.contextHolder.set(new TestContextHolder());
        getContext().setUserName(username);
    }

    @Given("with PATCH requestBody")
    public void createAuthenticationRequest22(String jsonData) {
        this.jsonPayload = jsonData;
    }

    @When("GET user")
    public void getUser() throws JsonProcessingException {
        getContext().setPrivateUser(userController.getUserEndpoint(getContext().getGithubToken()));
    }

    @When("GET user with expected {int}")
    public void getUser(int expectedStatusCode) throws JsonProcessingException {
        getContext().setPrivateUser(userController.getUserEndpoint(getContext().getGithubToken(), expectedStatusCode));
    }

    @When("GET user by userName with expected statusCode {int} and expected message {string}")
    public void getUser2(int expectedStatusCode, String expectedMessage) throws JsonProcessingException {
        getContext().setPrivateUser(userController.getUserByUsernameEndpoint(expectedStatusCode, expectedMessage, getContext().getUserName()));
    }

    @When("PATCH user")
    public void patchUser() throws JsonProcessingException {
        getContext().setPrivateUser(userController.patchUserEndpoint(getContext().getGithubToken(), jsonPayload));
    }

    @When("PATCH user with expected statusCode {int}")
    public void patchUser(int expectedStatusCode) throws JsonProcessingException {
        getContext().setPrivateUser(userController.patchUserEndpoint(getContext().getGithubToken(), jsonPayload, expectedStatusCode));
    }

    @Then("Verify that login is {string}")
    public void verifyLogin(String expectedLogin) {
        if("null".equals(expectedLogin)) {
            assertNull(getContext().getPrivateUser());
        }else{
            assertEquals(getContext().getPrivateUser().getLogin(),expectedLogin);
        }
    }

    @Then("Verify that name is {string}")
    public void verifyName(String expectedName) {
        if("null".equals(expectedName)) {
            assertNull(getContext().getPrivateUser());
        }else{
            assertEquals(getContext().getPrivateUser().getName(),expectedName);
        }
    }
}
