@ArrayList @signIn
Feature: Navigation and interaction in dsAlgo Portal - Array Section

  Rule: Below scenario covers with Array module
  Background:User is logged into the app
      When The user clicks the Get Started button in Array Panel

  Scenario: Verify user is able to navigate to Array page
       Then The user should be directed to Array Page

  Scenario: Verify user is able to navigate to Arrays in Python page
     When  The user clicks Arrays in Python link
    Then The user should be redirected to "Arrays in Python" page

  Scenario: Verify user is able to navigate to try Editor page for Arrays in Python
    When The user clicks Try Here button after reaching to arrays in python
    Then The user should be redirected to a page having a "tryEditor"

  Scenario: Verify the presence of Run button in try editor
    When The user clicks Try Here button after reaching to arrays in python
   Then The user should see a Run button in try editor


  Rule: Below scenario covers Array module with try editor
    Background:User is logged into the app
       Given The user is in the Array page after Sign in
      When The user clicks Try Here button after reaching to arrays in python

  Scenario Outline: Verify error message for Empty & invalid python code for Arrays in Python page
    When The user writes "<Code>" for "<scenarioType>" in Editor and clicks the Run button
    Then The user should see an error message in alert window

    Examples:
      | Code | scenarioType |
      |      | invalidCode  |
      | hi   | invalidCode  |

    Scenario Outline: Verify user is able to see output for valid python code for Arrays in Python page
    And The user writes "<dataDrivenColumnHeader>" for "<scenarioType>" in Editor and clicks the Run button
    Then The user should see output in the console for ArrayList Page
      Examples:
        | dataDrivenColumnHeader | scenarioType |
        | ArrayList              | validCode    |
    
