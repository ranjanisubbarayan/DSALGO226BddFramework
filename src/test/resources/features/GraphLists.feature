@Graph @signIn
Feature: Navigation and interaction in dsAlgo Portal - Graph Section

  Background: 
    Given The user is in the Home page after Sign in
     When The user selects the Get Started option under the Graph section
  
  Scenario: Open Graph main page from Home
     Then The Graph main page should appear
    
  Scenario Outline:: Navigate to Graph likns
    When  The user chooses "<graphLink>" link in Graph Page
    Then   The "<graphLink>" information page should load
    Then The user should be redirected to "<graphLink>" page
    
    Examples:
            |graphLink|
            |Graph|
            |Graph Representations|
            
    
    Scenario:
    When  The user chooses "<graphLink>" link in Graph Page
    When  The user selects the Try Editor button on Graph Topic page
    Then The user should be redirected to a page having a "tryEditor"
    
      Examples:
            |graphLink|
            |Graph|
            |Graph Representations|

  Scenario Outline: Validate alert handling for invalid input on Graph Topic Try Editor
    When  The user chooses "<graphLink>" link in Graph Page
    When  The user selects the Try Editor button on Graph Topic page
    When The user enters "<graphInput>" into the editor and clicks Run
    Then An alert message should be shown for Graph Topic invalid execution

    Examples:
     | graphLink             | graphInput |
      | Graph                 |      |
      | Graph                 | hi   |
      |Graph Representations |     |
      | Graph Representations | hi   |



 @GraphExcelData
  Scenario: Validate Excel handling for valid input on Graph Representations Try Editor
    When  The user chooses "<graphLink>" link in Graph Page
    When  The user selects the Try Editor button on Graph Topic page
	When  The user write valid code in Editor and clicks the Run Button in Graph Page
    Then The user should see output in the console for Graph Page
  Examples:
            |graphLink|
            |Graph|
            |Graph Representations|
            
 # ---- Graph Module Non-Functional Testin ----           
            
  @NonFunctional @performance
  Scenario: Verify Graph page loads within acceptable time
    Then Graph page should load within "5" seconds

 @NonFunctional  @usability
  Scenario: Verify key graph visualizer elements are visible  
    Then all main graph operations buttons should be visible

  @NonFunctional @security
  Scenario: Verify Graph page uses HTTPS
    Then Graph page should be loaded using HTTPS

  @NonFunctional @reliability
  Scenario: Refresh Graph page
    Then Graph page should load without errors
