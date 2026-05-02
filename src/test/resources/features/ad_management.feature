Feature: Advertisement Management
  As an authorized user
  I want to create, edit, and delete advertisements
  So that I can manage my listings

  @smoke @regression
  Scenario: Create new advertisement
    Given authorized user navigates to create ad page
    When user fills ad creation form with valid data
    Then ad should be created successfully

  @regression
  Scenario: Edit existing advertisement
    Given authorized user navigates to create ad page
    When user fills ad creation form with valid data
    And user edits the created ad
    Then ad should be updated successfully

#  @regression
#  Scenario: Delete advertisement
#    Given authorized user navigates to create ad page
#    When user fills ad creation form with valid data
#    And user deletes the ad
#    Then ad should be removed