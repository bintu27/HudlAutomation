@Regression @ResetPwd
Feature: User should be able to reset login password for valid userName

  Scenario: Verify user should be able to submit request to reset password from web application for valid user
    Given User is on the login page of the application
    When User click on Need Help Link
    Then User should be navigated to login help page

    When User enter "validEmail" to reset the password
    And User click on "Send Password Reset" button
    Then User should be navigated to check email page

  Scenario: Verify user should not be able to submit request to reset password from web application for invalid user
    Given User is on the login page of the application
    When User click on Need Help Link
    Then User should be navigated to login help page

    When User enter "invalidEmail" to reset the password
    And User click on "Send Password Reset" button
    Then User should get error message on help page

  @Api
  Scenario: Verify user should be able to submit Api request to reset password for valid user
    When User submit reset password API request with "validEmail"

  @Api
  Scenario: Verify user should be able to submit Api request to reset password for invalid user
    When User submit reset password API request with "invalidEmail"