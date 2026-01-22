@home @nonfunctional
Feature: DSAlgo Home Page Non Functional Testing

  @performance
  Scenario: Verify home page load performance
    Given user launches DSAlgo home page
    Then home page should load within acceptable time

  @usability
  Scenario: Verify home page usability
    Given user is on DSAlgo home page
    Then important home page options should be visible

  @security
  Scenario: Verify home page security
    Given user is on DSAlgo home page
    Then home page should be loaded using HTTPS

  @accessibility
  Scenario: Verify keyboard accessibility
    Given user is on DSAlgo home page
    Then user should be able to navigate home page using keyboard

  @reliability
  Scenario: Verify home page reliability on refresh
    Given user is on DSAlgo home page
    When user refreshes the home page
    Then home page should load without errors
