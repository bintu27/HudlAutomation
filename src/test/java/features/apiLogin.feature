@Regression @Login @Api @LoginApi
Feature: User should only be able to login successfully with valid credentials for Api request
  Scenario: Verify successful API login with valid credentials
    When User submit login API request with "validEmail" and "validPassword"

  Scenario Outline: Verify user should get error in API response with invalid credentials
    When User submit login API request with <Username> and <Password>

    Examples:
      | Username       | Password          |
      | "validEmail"   | "invalidPassword" |
      | "invalidEmail" | "validPassword"   |
      | "invalidEmail" | "invalidPassword" |