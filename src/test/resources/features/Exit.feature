Feature: Validate Exit Intent

  @Regression
  Scenario: Make sure exit intent is shown
    Given Go to the exit_intent page
    Then Move the mouse outside of the viewport
    And Verify and click on close button
