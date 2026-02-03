@home
Feature: DS_ALGO_APP Home Page Verification

Rule: Below scenario covers with Home module  
  Background:
  Given the user opens the browser
  When The user clicks the Get Started button in DS Algo Portal

Scenario: Verify DS Algo Portal landing page
  Then the DS Algo Portal page should be displayed with the Get Started button

Scenario: Navigate to Home page
 
  Then the user should be navigated to the Home page
  
  Scenario: User views the Data Structures dropdown options
    When User clicks the Data Structure dropdown
    Then The user should be able to see all modules in the dropdown:
      | Arrays       |
      | Linked List  |
      | Stack        |
      | Queue        |
      | Tree         |
      | Graph        |

 
  Scenario Outline: Selecting a module from the dropdown displays warning message
    When User selects module "<Module>" from the dropdown
    Then The user should be able to see a warning message "You are not logged in"

    Examples:
      | Module       |
      | Arrays       |
      | Linked List  |
      | Stack        |
      | Queue        |
      | Tree         |
      | Graph        |

  
  Scenario Outline: Clicking the Get Started button for a module displays warning
    When User clicks the Get Started button for module "<Module>"
    Then The user should be able to see a warning message "You are not logged in"
    
  Examples:
  | Module                      |
  | Data Structures             |
  | Array                       |
  | Linked List                 |
  | Stack                       |
  | Queue                       |
  | Tree                        |
  | Graph                       |


     #----Home Module Non-Functional Testing---

  Rule: Below scenario covers Home module Non functional feature
  Background:
  Given the user opens the browser
  When The user clicks the Get Started button in DS Algo Portal

  @nonhfunctional @performance 
  Scenario: Verify home page load performance    
    Then home page should load within "5" seconds

  @nonhfunctional @usability
  Scenario: Verify home page usability   
    Then important home page options should be visible

  @nonhfunctional @security
  Scenario: Verify home page security    
    Then home page should be loaded using HTTPS

  @nonhfunctional @reliability
  Scenario: Verify home page reliability on refresh
    When user refreshes the home page
    Then home page should load without errors

