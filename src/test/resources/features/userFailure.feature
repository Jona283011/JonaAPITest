Feature: GitHub API failure testing

  Scenario Outline: Basic User with failure PATCH
    Given Default user with github token "<githubToken>"
    And with PATCH requestBody
         """
      {
        "name": "<updatedName>"
      }
      """
    When PATCH user with expected statusCode <expectedStatusCode>
    And GET user
    Then Verify that name is "<expectedName>"

    Examples:
     | githubToken  | expectedStatusCode | updatedName                                                                                                                                                                                                                                                      | expectedName |
     | github.token | 422                | PepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepe | failure      |