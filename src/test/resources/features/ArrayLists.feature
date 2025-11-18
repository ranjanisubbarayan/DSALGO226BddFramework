@ArrayList
Feature: Navigation and interaction in dsAlgo Portal - Array Section

  Background:
    Given The user sign in to dsAlgo Portal entering firstname Vara & password Varam@123

  Scenario: Verify user is able to navigate to Array page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button in Array Panel
    Then The user should be directed to Array Page

  Scenario: Verify user is able to navigate to Arrays in Python page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button in Array Panel
    Then The user should be directed to Array Page
    And The user clicks Arrays in Python link
    Then The user should be redirected to Arrays in Python page

  Scenario: Verify user is able to navigate to try Editor page for Arrays in Python
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button in Array Panel
    Then The user should be directed to Array Page
    And The user clicks Arrays in Python link
    And The user clicks Try Here button in Arrays in Python page
    Then The user should be redirected to a page having a try Editor with a Run button to test

  Scenario Outline: Verify error message for Empty & invalid python code for Arrays in Python page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button in Array Panel
    Then The user should be directed to Array Page
    And The user clicks Arrays in Python link
    And The user clicks Try Here button in Arrays in Python page
    And The user should be redirected to a page having a try Editor with a Run button to test
    And The user writes "<code>" in Editor and clicks the Run button
    Then The user should see an error message in alert window

    Examples:
      | code |
      |      |
      | hi   |

  Scenario: Verify user is able to see output for valid python code for Arrays in Python page
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button in Array Panel
    Then The user should be directed to Array Page
    And The user clicks Arrays in Python link
    And The user clicks Try Here button in Arrays in Python page
    And The user should be redirected to a page having a try Editor with a Run button to test
    And The user writes valid code in Editor and clicks the Run Button
    Then The user should see output in the console
