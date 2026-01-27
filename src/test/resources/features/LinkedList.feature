@LinkedList @signIn
Feature: Navigation and interaction in dsAlgo Portal - Linked List Section

  Background:User is logged into the app

  @smoke_Ll
  Scenario: Verify user is able to navigate to Linked List Page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button
    Then The user should be directed to Linked List Page

  @smoke_Ll
  Scenario: Verify user is able to see output for valid Linked List code for Introduction page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button
    Then The user should be redirected to "Linked List" page


    When the user clicks the Introduction link

