@StackList @signIn
Feature: Navigation and interaction in dsAlgo Portal - Stack Section

  Rule: Below scenarios cover Stack module functionality

  Background:
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button in Stack Panel

  Scenario: Verify user is able to navigate to Stack page
    Then The user should be directed to Stack Page

  Scenario Outline: Verify user is able to navigate to Stack pages
    When The user clicks "<StackLinks>" in Stack link page
    Then The user should be redirected to "<StackLinks>" page

    Examples:
      |StackLinks|
      |Operations in Stack|
      |Implementation|
      |Applications|
      |Practice Questions|

  Scenario Outline: Verify user is able to navigate to try Editor page for Stack pages
    When The user clicks "<StackLinks>" in Stack link page
    When  The user clicks Try Here button after reaching Stack page
    Then The user should be redirected to a page having a "tryEditor"

    Examples:
      |StackLinks|
      |Operations in Stack|
      |Implementation|
      |Applications|

  Scenario Outline: Verify the presence of Run button in try editor for Stack pages
    When The user clicks "<StackLinks>" in Stack link page
    When The user clicks Try Here button after reaching Stack page
    Then The user should see a Run button in try editor

    Examples:
      |StackLinks|
      |Operations in Stack|
      |Implementation|
      |Applications|

  Scenario Outline: Verify error message for empty & invalid python code in Stack try editor
    When The user clicks "<StackLinks>" in Stack link page
    When The user clicks Try Here button after reaching Stack page
    When The user writes "<Code>" for "<scenarioType>" in Editor and clicks the Run button in stack page
    Then The user should see an error message in alert window

    Examples:
      |StackLinks|Code|scenarioType|
      |Operations in Stack|      | invalidCode |
      |Operations in Stack| hi   | invalidCode |
      |Implementation|      | invalidCode |
      |Implementation| hi   | invalidCode |
      |Applications|      | invalidCode |
      |Applications| hi   | invalidCode |

  Scenario Outline: Verify user is able to see output for valid python code in Stack pages
    When The user clicks "<StackLinks>" in Stack link page
    When The user clicks Try Here button after reaching Stack page
    When  The user writes "<dataDrivenColumnHeader>" for "<scenarioType>" in Editor and clicks the Run button in stack page
    Then The user should see output in the console for Stack Page

    Examples:
      |StackLinks|dataDrivenColumnHeader|scenarioType|
      |Operations in Stack|StackList|validCode|
      |Implementation|StackList|validCode|
      |Applications|StackList|validCode|
      
      
      
      
        #----Array Module Non-Functional Testin---
  
   Rule: Below scenario covers Stack module Non functional feature      
   
   Background:
    Given The user is in the Home page after Sign in
    When The user clicks the Get Started button in Stack Panel
        
  @performance @nonsfunctional
  Scenario: Verify Stack page loads within acceptable time
    Then Stack page should load within "5" seconds

  @usability @nonsfunctional
  Scenario: Verify key stack elements are visible
    Then all main stack operations buttons should be visible

  @security @nonsfunctional
  Scenario: Verify Stack page uses HTTPS
    Then Stack page should be loaded using HTTPS

  @reliability @nonsfunctional
  Scenario: Refresh Stack page
    When user refreshes the Stack page
    Then Stack page should load without errors
	

