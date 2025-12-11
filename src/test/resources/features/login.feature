
@smoke @Login
Feature: Login to DS Algo Portal

  Scenario: Navigate to Login page
    Given user is on the Login page
    When the user clicks the "Sign in" link on the Home page
    And the user clicks the login button
    Then the Sign in form should be displayed

  Scenario Outline: Login attempts with various credentials
    Given user is on the login page
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then "<expectedMessage>" should be displayed

    Examples:
      | username    | password           | expectedMessage                      |
      |            |                   | Please fill out this field             |
      |            | C5Mha6FkdSAVEN@   | Please fill out this field             |
      | TestNinja  |                   | Please fill out this field             |
      | Testuser   | C5Mha6FkdSAVEN@   | Invalid Username and Password          |
      | TestNinja  | wrongpassword     | Invalid Username and Password          |
      | TestNinja  | C5Mha6FkdSAVEN@   | Home page displayed                    |

    Scenario Outline: Login test using Excel data
    Given I read login test data for "<testId>"
    When I enter the login details from excel
    Then I should see the ExpectedResult
    Then I capture screenshot "LoginPage"
  Examples:
    | testId |
    | L1     |
    | L2     | 
    

    