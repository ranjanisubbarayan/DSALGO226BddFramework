@home
Feature: DS_AGLO_APP Home Page Verification   
As a user
  I want to verify the home page elements and content
  So that I can ensure the application home page is displayed correctly
  
  Scenario: User opens the DS Algo Portal	
   Given  The user has to open browser	
   When  the user enter the correct DS Algo Portal URL		
   Then  The user able to land on the DS Algo portal with Get Started button
   
   Scenario: User Accesses the Home page   
   Given The user is on the DS Algo Portal	
   When Landing on the page		
   Then  The user shouble able to navigated to the Home page, which displays the Register and Sign in links


    Scenario: User views the Data Structures dropdown options
    Given The user is on Home page
    When User clicks the Data Structure dropdown
    Then The user should be able to see all modules in the dropdown:
      | Arrays       |
      | Linked List  |
      | Stack        |
      | Queue        |
      | Tree         |
      | Graph        |

 
  Scenario Outline: Selecting a module from the dropdown displays warning message
    Given The user is on Home page
    When User selects module "<Module>" from the dropdown
    Then The user should be able to see a warning message "You are not logged in"

    Examples:
      | Module      |
      | Arrays       |
      | Linked List  |
      | Stack        |
      | Queue        |
      | Tree         |
      | Graph        |

  
  Scenario Outline: Clicking the Get Started button for a module displays warning
    Given The user is on Home page
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


   



