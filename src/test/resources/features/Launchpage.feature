  @launchPage
  Feature: DS Algo Portal functional testing

  Background: User launches the browser and navigates to DS Algo portal
    Given user has a browser open
    When  user enters the correct DS Algo portal URL

  Scenario: Endpoint of the launch page URL
    Then user should be on the DS Algo Portal page with "Numpy Ninja" title

  Scenario: Content text on the Launch page

    Then user should be able to see the content text on the Launch page
      | Preparing for the Interviews|
      |You are at the right place|

  Scenario: Launch page should have 1 button
    Then user should be able to see 1 button on the Launch page

  Scenario: Presence of button
    Then user should be able to see button

  @buttonText
  Scenario: The button should have text "Get Started"
    Then user should be able to see button with text "Get Started"

  @LaunchFunctional_TC
  Scenario: Verify State of Get Started Button

    When User clicks on Get Started Button
    Then User should navigate to home page with "NumpyNinja" title


  Scenario: User navigates from Launch Page to Home Page
    Given user is on the launch page
    When user clicks on Get Started button
    Then user should be navigated to the home page