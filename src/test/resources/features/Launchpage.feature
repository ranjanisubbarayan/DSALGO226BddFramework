Feature: Launch Page functionality

  Scenario: User navigates from Launch Page to Home Page
    Given user is on the launch page
    When user clicks on Get Started button
    Then user should be navigated to the home page
