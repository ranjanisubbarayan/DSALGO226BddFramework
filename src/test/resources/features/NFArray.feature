@ArrayList @nonfunctional
Feature: Array Module Non-Functional Testing
   
  @performance
  Scenario: Verify Array page loads within acceptable time
    Given user is on Array page
    Then Array page should load within "5" seconds

  @usability
  Scenario: Verify key array elements are visible
    Given user is on Array page
    Then all main array operations buttons should be visible

  @security
  Scenario: Verify Array page uses HTTPS
    Given user is on Array page
    Then Array page should be loaded using HTTPS

  @reliability
  Scenario: Refresh Array page
    When user refreshes the Array page
    Then Array page should load without errors
