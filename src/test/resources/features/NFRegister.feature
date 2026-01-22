@register @nonfunctional
Feature: Register Module Non-Functional Testing

  @performance
  Scenario: Verify Register page loads within acceptable time
    Given user is on Register page
    Then Register page should load within "5" seconds

  @usability
  Scenario: Verify all input fields and submit button are visible
    Given user is on Register page
    Then all input fields and submit button should be visible

  @security
  Scenario: Verify Register page uses HTTPS
    Given user is on Register page
    Then Register page should be loaded using HTTPS

  @accessibility
  Scenario: Verify keyboard navigation works
    Given user is on Register page
    Then user should be able to navigate Register page using keyboard

  @reliability
  Scenario: Refresh Register page
    When user refreshes the Register page
    Then Register page should load without errors
