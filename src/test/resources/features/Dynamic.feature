Feature: Validate Dynamic Control Page

  @Regression
  Scenario Outline: Verify Enable/disable input field
    Given Go to the dynamic_controls page
    Then Click on Enable button and Verify the input field
    And Verify success message for Enable
    And Enter <value> in the input
    Then Click on Disable button and Verify the input field
    And Verify success message for Disable
    And Verify that string is available in the input

    Examples:
      | value |
      | Test  |