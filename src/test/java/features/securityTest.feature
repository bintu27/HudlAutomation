@Regression @SecurityTests
Feature: Application security test against XSS & SQL Injection vulnerabilities

  Scenario Outline: Validate client side against XSS vulnerabilities
    Given User is on the login page of the application
    When User logs in with <Username> and <Password>
    Then User should get "invalid" login error message on login page

    Examples:
      | Username     | Password        |
      | "xssInput"   | "validPassword" |
      | "validEmail" | "xssInput"      |
      | "xssInput"   | "xssInput"      |

  Scenario Outline: Validate client side against SQL Injection vulnerabilities
    Given User is on the login page of the application
    When User logs in with <Username> and <Password>
    Then User should get "invalid" login error message on login page

    Examples:
      | Username     | Password        |
      | "sqlInput"   | "validPassword" |
      | "validEmail" | "sqlInput"      |
      | "sqlInput"   | "sqlInput"      |

  @Api
  Scenario Outline: Validate server side against XSS vulnerabilities
    When User submit login API request with <Username> and <Password>

    Examples:
      | Username     | Password        |
      | "xssInput"   | "validPassword" |
      | "validEmail" | "xssInput"      |
      | "xssInput"   | "xssInput"      |

  @Api
  Scenario Outline: Validate server side against SQL Injection vulnerabilities
    When User submit login API request with <Username> and <Password>

    Examples:
      | Username     | Password        |
      | "sqlInput"   | "validPassword" |
      | "validEmail" | "sqlInput"      |
      | "sqlInput"   | "sqlInput"      |