Feature: Validate Login

  @Regression
  Scenario Outline: Login
    Given Go to the login page
    And Verify the login page
    Then Enter login credentials for the <user>
    And Click on login button
    Then Verify message on Login page for <user>
    And Logout after successful login for <user>

    Examples:
      | user    |
      | valid   |
      | invalid |

