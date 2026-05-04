Feature: User Registration
  As a new user
  I want to register on the platform
  So that I can post advertisements

  @smoke @regression
  Scenario: Successful registration with unique email
    Given user navigates to registration page
    When user fills registration form with unique email
    And user submits registration form
    Then user should see success registration message

  @regression
  Scenario: Registration with existing email
    Given user is already registered via API
    And user navigates to registration page
    When user fills registration form with the same email
    And user submits registration form
    Then user should see error message about existing email