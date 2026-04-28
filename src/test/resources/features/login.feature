Feature: User Login
  As a registered user
  I want to log into the system
  So that I can access my account

  @smoke @regression
  Scenario: Successful login with valid credentials
    Given registered user navigates to login page
    When user enters valid credentials
    Then user should be logged in successfully