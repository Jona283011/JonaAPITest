Feature: GitHub API testing

  Scenario: Basic User
    Given Default user with github token "github.token"
    When GET user
    Then Verify that login is "Jona283011"

  Scenario Outline: Basic User with statusCode
    Given Default user with github token "<githubToken>"
    When GET user with expected <expectedStatusCode>
    Then Verify that login is "<expectedLogin>"

    Examples:
      | expectedStatusCode | expectedLogin  | githubToken   |
      | 200                | Jona283011     | github.token  |
      | 401                | null           | github.token2 |

  Scenario Outline: Basic User with statusCode username
    Given Default user with username "<userName>"
    When GET user by userName with expected statusCode <expectedStatusCode> and expected message "<message>"
    Then Verify that login is "<expectedLogin>"
    Then Verify that name is "<expectedName>"

    Examples:
      | expectedStatusCode | message    | userName         | expectedLogin  | expectedName |
      | 200                | OK         | Jona283011       | Jona283011     | Jonathan     |
      | 404                | Not Found  | nonExistingUser  | null           | null         |

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
      | expectedStatusCode | updatedName                                                                                                                                                                                                                                                      | githubToken   | expectedName |
      | 422                | PepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepePepe | github.token  | Jonathan     |

  Scenario: Basic User with PATCH
    Given Default user with github token "github.token"
    And with PATCH requestBody
         """
      {
        "name": "Pepe"
      }
      """
    When PATCH user
    And GET user
    And Verify that name is "Pepe"
    And with PATCH requestBody
         """
      {
        "name": "Jonathan"
      }
      """
    When PATCH user
    And Verify that name is "Jonathan"
