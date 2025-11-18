Feature: Navigation and interaction in dsAlgo Portal - Linked List Section

  Background:
    Given The user sign in to dsAlgo Portal entering firstname Vara & password Varam@123

  Scenario: Verify user is able to navigate to Linked List Page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button
    Then The user should be directed to Linked List Page

  Scenario: Verify user is able to navigate to Introduction page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button
    And The user should be directed to Linked List Page
    And The user clicks Introduction link
    Then The user should be redirected to Introduction page

  Scenario: Verify user is able to navigate to Try here page for Introduction page
    Given the user is on the Home page after signing in
    When the user clicks the Get Started button
    Then the user should be navigated to the Linked List page
    When the user clicks the Introduction link
    And the user clicks the Try Here button on the Introduction page
    Then the user should be redirected to a page containing a Try Editor with a Run button to test code

  Scenario: Scenario Outline: Verify error message for Empty & invalid code in tryEditor page
    Given the user is on the Home page after signing in
    When the user clicks the Get Started button
    Then the user should be navigated to the Linked List page
    When the user clicks the Introduction link
    And the user clicks the Try Here button on the Introduction page
    Then the user should be redirected to a page containing a Try Editor with a Run button to test code
    And The user writes "<code>" in Editor and clicks the Run button
    Then The user should see an error message in alert window

  Scenario: Verify user is able to see output for valid Linked List code for "Introduction" page
    Given the user is on the Home page after signing in
    When the user clicks the Get Started button
    Then the user should be navigated to the Linked List page
    When the user clicks the Introduction link
    And the user clicks the Try Here button on the Introduction page
    Then the user should be redirected to a page containing a Try Editor with a Run button to test code

    And The user writes valid code in Editor and clicks the Run Button
    Then The user should see output in the console

  Scenario: Verify user is able to navigate to "Practice Questions" Page for "Linked List" page
    Given The user is in the "Linked List" page after Sign in
    When The user clicks "Practice Questions" button
    Then The user should be redirected to "Practice" page
