Feature: Queue Module Tests

  Background:
    Given The user signs in to DS Algo Portal for QUEUE module with username "TestNinja" and password "C5Mha6FkdSAVEN@" 
    And The user clicks on "Get Started" button in Queue module


  Scenario Outline: Verify Queue module navigation and tryEditor actions
    Given The user is on the "<page>" in Queuepage
    When The user clicks "<action>" button in Queuepage
    And  If applicable, user enters "<code>" in the editor in Queuepage
    Then The user should see "<expectedResult>" in Queuepage

    Examples:
      | page                          | action                             | code                  | expectedResult                                   |
      | Home                          | Getting Started                    |                       | Queue Data Structure Page                        |
      | Queue                         | Implementation of Queue in Python  |                       | Implementation of Queue in Python page          |
      | Implementation of Queue in Python | Try Here                        |                       | tryEditor page with Run button                  |
      | tryEditor                     | Run without code                   |                       | error message alert                              |
      | tryEditor                     | Run with invalid code              | print("invalid")      | error message alert                              |
      | tryEditor                     | Run with valid code                | print("Hello World")  | console output                                   |
      | Queue                         | Practice Questions                 |                       | Practice page                                    |
      | Queue                         | Implementation using collections.deque |                       | Implementation using collections.deque page    |
      | Implementation using collections.deque | Try Here                     |                       | tryEditor page with Run button                  |
      | tryEditor                     | Run without code                   |                       | error message alert                              |
      | tryEditor                     | Run with invalid code              | print("invalid")      | error message alert                              |
      | tryEditor                     | Run with valid code                | print("Hello World")  | console output                                   |
      | Queue                         | Practice Questions                 |                       | Practice page                                    |
      | Queue                         | Implementation using array         |                       | Implementation using array page                 |
      | Implementation using array    | Try Here                           |                       | tryEditor page with Run button                  |
      | tryEditor                     | Run without code                   |                       | error message alert                              |
      | tryEditor                     | Run with invalid code              | print("invalid")      | error message alert                              |
      | tryEditor                     | Run with valid code                | print("Hello World")  | console output                                   |
      | Queue                         | Practice Questions                 |                       | Practice page                                    |
      | Queue                         | Queue Operations                   |                       | Queue Operations page                            |
      | Queue Operations              | Try Here                           |                       | tryEditor page with Run button                  |
      | tryEditor                     | Run without code                   |                       | error message alert                              |
      | tryEditor                     | Run with invalid code              | print("invalid")      | error message alert                              |
      | tryEditor                     | Run with valid code                | print("Hello World")  | console output                                   |
      | Queue                         | Practice Questions                 |                       | Practice page                                    |
