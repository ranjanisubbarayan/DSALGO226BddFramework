@LinkedList
Feature: Navigation and interaction in dsAlgo Portal - Linked List Section

  Background:
    Given The user sign in to dsAlgo Portal entering firstname Vara & password Varam@123

  @smoke_Ll
  Scenario: Verify user is able to navigate to Linked List Page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button
    Then The user should be directed to Linked List Page

  @smoke_Ll
  Scenario: Verify user is able to see output for valid Linked List code for Introduction page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button
    Then The user should be directed to Linked List Page
    When the user clicks the Introduction link
    And the user clicks the Try Here button on the Introduction page
    And The user write valid Linked List code in Editor and clicks the Run Button
    Then The user should see output in the console
