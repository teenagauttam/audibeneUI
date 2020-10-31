Feature: Validate Tables

  @Regression
  Scenario: Verify sorting of table names
    Given Go to the tables page
    And Check the length of tables
    Then Click on last name on table 1
    Then Verify the alphabet order of lastName in table 1
    And Click on first name on table 2
    Then Verify the alphabet order of firstName in table 2