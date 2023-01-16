@Regression @Login
Feature: User should be able to login into web application only with valid credentials

  Scenario: Verify valid user should be able to log in and log out
    Given User is on the login page of the application
    When User logs in using valid login credentials
    Then User should be navigated to home page

    When User click on the top right menu icon
    And User click on Logout menu option
    Then User should be navigated back to base page

  Scenario: Verify user should not be able to log in without entering any credentials
    Given User is on the login page of the application
    When User click logs in button with no credentials entered
    Then User should get "invalid" login error message on login page

  Scenario: Verify invalid user should not be able to login via SSO
    Given User is on the login page of the application
    When User click on Log In with an Organization button
    Then User should be navigated to Organization login page

    When User click on login with invalid Organization email
    Then User should get "SSO" login error message on login page

  Scenario Outline: Verify user should not be able to login with invalid credentials
    Given User is on the login page of the application
    When User logs in with <Username> and <Password>
    Then User should get "invalid" login error message on login page

    Examples:
      | Username        | Password           |
      | "invalidEmail" | "invalidPassword" |
      | "validEmail"   | "invalidPassword" |
      | "invalidEmail" | "validPassword"   |

  Scenario: Verify user remember me store values
    Given User is on the login page of the application
    When User click on Remember me checkbox
    When User logs in using valid login credentials