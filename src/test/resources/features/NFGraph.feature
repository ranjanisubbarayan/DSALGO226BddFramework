@Graph @nonfunctional
Feature: Graph Module Non-Functional Testing

  @performance
  Scenario: Verify Graph page loads within acceptable time
    Given user is on Graph page
    Then Graph page should load within "5" seconds

  @usability
  Scenario: Verify key graph visualizer elements are visible
    Given user is on Graph page
    Then all main graph operations buttons should be visible

  @security
  Scenario: Verify Graph page uses HTTPS
    Given user is on Graph page
    Then Graph page should be loaded using HTTPS

  @reliability
  Scenario: Refresh Graph page
    When user refreshes the Graph page
    Then Graph page should load without errors
