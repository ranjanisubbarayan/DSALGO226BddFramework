@ArrayList @signIn
Feature: Navigation and interaction in dsAlgo Portal - Array Section

  Rule: Below scenario covers with Array module
  Background: 
      Given The user is in the Home page after Sign in
      When The user clicks the Get Started button in Array Panel

  Scenario: Verify user is able to navigate to Array page
       Then The user should be directed to Array Page

  Scenario Outline:: Verify user is able to navigate to Arrays in Python page
     When  The user clicks "<ArrayLinks>" in link page
    Then The user should be redirected to "<ArrayLinks>" page
    
    Examples:
            |ArrayLinks|
            |Arrays in Python|
            |Arrays Using List|
            |Basic Operations in Lists|
            |Applications of Array|
                     
  Scenario Outline:: Verify user is able to navigate to try Editor page for Arrays in Python
      When  The user clicks "<ArrayLinks>" in link page
    When The user clicks Try Here button after reaching to arrays in python
    Then The user should be redirected to a page having a "tryEditor"  
    
     Examples:
            |ArrayLinks|
            |Arrays in Python|
            |Arrays Using List|
            |Basic Operations in Lists|
            |Applications of Array|
          
  Scenario Outline:: Verify the presence of Run button in try editor
   When  The user clicks "<ArrayLinks>" in link page
    When The user clicks Try Here button after reaching to arrays in python
   Then The user should see a Run button in try editor
   
    Examples:
            |ArrayLinks|
            |Arrays in Python|
            |Arrays Using List|
            |Basic Operations in Lists|
            |Applications of Array|
           
  Scenario Outline: Verify error message for Empty & invalid python code for Arrays in Python page
   When  The user clicks "<ArrayLinks>" in link page
   When The user clicks Try Here button after reaching to arrays in python
   When The user writes "<Code>" for "<scenarioType>" in Editor and clicks the Run button
    Then The user should see an error message in alert window

    Examples:
     | ArrayLinks| Code | scenarioType |
     |Arrays in Python|      |invalidCode  |
     |Arrays in Python| hi   |invalidCode  |
      |Arrays Using List|      |invalidCode  |
     |Arrays Using List| hi   | invalidCode  |
      |Basic Operations in Lists|      |invalidCode  |
     |Basic Operations in Lists| hi   | invalidCode  |
      |Applications of Array|      | invalidCode  |
     |Applications of Array| hi   | invalidCode  |
     
    Scenario Outline: Verify user is able to see output for valid python code for Arrays in Python page
     When  The user clicks "<ArrayLinks>" in link page
     When The user clicks Try Here button after reaching to arrays in python
     When The user writes "<dataDrivenColumnHeader>" for "<scenarioType>" in Editor and clicks the Run button
     Then The user should see output in the console for ArrayList Page
      Examples:
      |ArrayLinks  | dataDrivenColumnHeader | scenarioType |
       |Arrays in Python| ArrayList              | validCode    |
         |Arrays Using List| ArrayList              | validCode    |
           |Basic Operations in Lists| ArrayList              | validCode    |
    
    #----Array Module Non-Functional Testin---
    
    Rule: Below scenario covers Array module Non functional feature
    Background: User is logged into the app
      Given The user is in the Home page after Sign in
      When The user clicks the Get Started button in Array Panel
    
  @nonfunctional  @performance
  Scenario: Verify Array page loads within acceptable time
    Then Array page should load within "5" seconds

 @nonfunctional   @usability
  Scenario: Verify key array elements are visible and clickable
    Then all main array operations elements should be visible and clickable

  @nonfunctional  @security
  Scenario: Verify Array page uses HTTPS
    Then Array page should be loaded using HTTPS

 @nonfunctional  @reliability
  Scenario: Refresh Array page
    When user refreshes the Array page
    Then Array page should load without errors

