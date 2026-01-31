@Login
Feature: Login to DS Algo Portal

Rule: Below scenario covers with Login module

Background: Given user is on the Login page

  Scenario: Navigate to Login page
    Given user is on the Login page
    When the user clicks the "Sign in" link on the Home page
    When the user clicks the login button
    Then the Sign in form should be displayed

  Scenario Outline: Login attempts with various credentials
    Given user is on the Login page
    When the user enters "<username>" and "<password>"
    When the user clicks the login button
    Then "<expectedMessage>" should be displayed

    Examples:
      | username   | password          | expectedMessage                        |
      |            |                   | Please fill out this field             |
      |            | C5Mha6FkdSAVEN@   | Please fill out this field             |
      | TestNinja  |                   | Please fill out this field             |
      | Testuser   | C5Mha6FkdSAVEN@   | Invalid Username and Password          |
      | TestNinja  | wrongpassword     | Invalid Username and Password          |
      | TestNinja  | C5Mha6FkdSAV      | Home page displayed                    |

    Scenario Outline: Login test using Excel data
    Given I read login test data for "<testId>"
    When I enter the login details from excel
    Then I should see the ExpectedResult
    
  Examples:
    | testId |ExpectedResult                |
    | TC001  |Invalid Username and Password |
    | TC002  |Please fill out this field    | 
    | TC003  |Please fill out this field    | 
    | TC004  |Please fill out this field    | 
    | TC005  |Invalid Username and Password |
    | TC006  |You are logged in             |
    
     #----Login Module Non-Functional Testing---

  Rule: Below scenario covers Login module Non functional feature
  
  Background: Given user is on the Login page
  
   @nonfunctional @performance
   Scenario: Verify Login page loads within acceptable time
       Then Login page should load within "5" seconds

  @nonfunctional @usability
  Scenario: Verify all login fields and button are visible
        Then all login fields and buttons should be visible

  @nonfunctional @security
  Scenario: Verify Login page uses HTTPS
    Then Login page should be loaded using HTTPS

  @nonfunctional @accessibility
  Scenario: Verify keyboard navigation works
    Then user should be able to navigate Login page using keyboard

  @nonfunctional @reliability
  Scenario: Refresh Login page
    When  user refreshes the Login page
    Then Login page should load without errors
  
    
