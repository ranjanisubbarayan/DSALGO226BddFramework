@Login @nonfunctional
Feature: Login Module Non-Functional Testing

  @performance
  Scenario: Verify Login page loads within acceptable time
    Given user is on Login page
    Then Login page should load within "5" seconds

  @usability
  Scenario: Verify all login fields and button are visible
    Given user is on Login page
    Then all login fields and buttons should be visible

  @security
  Scenario: Verify Login page uses HTTPS
    Given user is on Login page
    Then Login page should be loaded using HTTPS

  @accessibility
  Scenario: Verify keyboard navigation works
    Given user is on Login page
    Then user should be able to navigate Login page using keyboard

  @reliability
  Scenario: Refresh Login page
    When user refreshes the Login page
    Then Login page should load without errors
