@login
Feature: Login to DS Algo Portal

  Scenario Outline: Valid login with multiple credentials
    Given user is on the login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then user should be navigated to the home page

  Examples:
    | username   | password         |
    | TestNinja  | C5Mha6FkdSAVEN@ |
