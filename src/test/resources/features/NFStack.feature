@Stack @nonfunctional
Feature: Stack Module Non-Functional Testing
  
  @performance
  Scenario: Verify Stack page loads within acceptable time
    Given user is on Stack page
    Then Stack page should load within "5" seconds

  @usability
  Scenario: Verify key stack elements are visible
    Given user is on Stack page
    Then all main stack operations buttons should be visible

  @security
  Scenario: Verify Stack page uses HTTPS
    Given user is on Stack page
    Then Stack page should be loaded using HTTPS

  @reliability
  Scenario: Refresh Stack page
    When user refreshes the Stack page
    Then Stack page should load without errors
	