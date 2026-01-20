@home @nonfunctional
Feature: Home Page Non-Functional Scenario 

  @performance
  Scenario: Verify Home page loads within acceptable time
    Given The user opens the DS Algo Portal Home page
    Then The Home page should load within "5" seconds

  @usability
  Scenario: Verify elements are visible on Home page
    Given The user opens the DS Algo Portal Home page
    Then The Get Started button should be visible
    And The Sign in link should be visible
    And The Register link should be visible
