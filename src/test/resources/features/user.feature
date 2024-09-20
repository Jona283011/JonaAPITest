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
      | githubToken   | expectedStatusCode | expectedLogin  |
      | github.token  | 200                | Jona283011     |
      | github.token2 | 401                | null           |

  Scenario Outline: Basic User with statusCode username
    Given Default user with username "<userName>"
    When GET user by userName with expected statusCode <expectedStatusCode> and expected message "<message>"
    Then Verify that login is "<expectedLogin>"
    Then Verify that name is "<expectedName>"

    Examples:
     | userName        | expectedStatusCode | message    | expectedLogin  | expectedName |
     | Jona283011      | 200                | OK         | Jona283011     | Jonathan     |
     | nonExistingUser | 404                | Not Found  | null           | null         |

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
