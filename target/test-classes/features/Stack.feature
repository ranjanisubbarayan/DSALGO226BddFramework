Feature: Stack Module Tests

  Background:
    Given The user signs in to DS Algo Portal for stack module with username "TestNinja" and password "C5Mha6FkdSAVEN@" 
    And The user clicks on "Get Started" button in stack module


  Scenario Outline: Verify Stack module navigation and tryEditor actions
    Given The user is on the "<page>" in stackpage
    When The user clicks "<action>" button in stackpage
    And If applicable, user enters "<code>" in the editor in stackpage
    Then The user should see "<expectedResult>" in stackpage

    Examples: 
      | page             | action                     | code                  | expectedResult                                    |
      | Home             | Getting Started            |                       | Stack Data Structure Page                          |
      | Stack            | Operations in Stack        |                       | Operations in Stack page                            |
      | Operations in Stack | Try Here                 |                       | tryEditor page with Run button                     |
      | tryEditor        | Run without code           |                       | error message alert                                |
      | tryEditor        | Run with invalid code      | print("invalid")      | error message alert                                |
      | tryEditor        | Run with valid code        | print("Hello World")  | console output                                     |
      | Stack            | Practice Questions         |                       | Practice page                                      |
      | Stack            | Implementation             |                       | Implementation page                                |
      | Implementation   | Try Here                   |                       | tryEditor page with Run button                     |
      | tryEditor        | Run without code           |                       | error message alert                                |
      | tryEditor        | Run with invalid code      | print("invalid")      | error message alert                                |
      | tryEditor        | Run with valid code        | print("Hello World")  | console output                                     |
      | Stack            | Practice Questions         |                       | Practice page                                      |
      | Stack            | Applications               |                       | Applications page                                  |
      | Applications     | Try Here                   |                       | tryEditor page with Run button                     |
      | tryEditor        | Run without code           |                       | error message alert                                |
      | tryEditor        | Run with invalid code      | print("invalid")      | error message alert                                |
      | tryEditor        | Run with valid code        | print("Hello World")  | console output                                     |
      | Stack            | Practice Questions         |                       | Practice page                                      |
