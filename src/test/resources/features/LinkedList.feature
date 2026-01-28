@LinkedList @signIn
Feature: Navigation and interaction in dsAlgo Portal - Linked List Section

 Background: 
    Given The user is in the Home page after Sign in
     When The user clicks the Get Started button in Linkedlist

  Scenario: Verify user is able to navigate to Linked List Page
    Then The user should be directed to Linked List Page

  Scenario Outline:: Verify user is able to navigate to LinkedList in Python page
     When  The user clicks "<LinkedLinks>" in LinkedList page
    Then The user should be redirected to "<LinkedLinks>" page
    
    Examples:
            |LinkedLinks|
            |Introduction|
            |Creating Linked LIst|
            |Types of Linked List|
            |Implement Linked List in Python|
            |Traversal|
            |Insertion|
            |Deletion|
           
Scenario Outline: Verify user able to navigate to tryeditor page for linkedlist 
   When  The user clicks "<LinkedLinks>" in LinkedList page
   When the user clicks the Try Here button on the Linked page
   Then The user should be redirected to a page having a "tryEditor"  

   
    Examples:
            |LinkedLinks|
            |Introduction|
            |Creating Linked LIst|
            |Types of Linked List|
            |Implement Linked List in Python|
            |Traversal|
            |Insertion|
            |Deletion|
            
 
  Scenario Outline: Verify error message for Empty & invalid python code for Linkedlist in Python page
  When  The user clicks "<LinkedLinks>" in LinkedList page
  When the user clicks the Try Here button on the Linked page
  When The user writes "<Code>" for "<scenarioType>" in Editor and clicks the Run button in LinkedList Page
  Then The user should see output in the console for Linkedlist Page

    Examples:
|LinkedLinks|Code  | scenarioType |
|Introduction|  | invalidCode  |
|Introduction| hi    | invalidCode  |
|Creating Linked List|  | invalidCode  |
|Creating Linked List| hi    | invalidCode  |
|Types of Linked List|  | invalidCode  |
|Types of Linked List| hi    | invalidCode  |
|Implement Linked List in Python|  | invalidCode  |
|Implement Linked List in Python| hi    | invalidCode  |
|Traversal|  | invalidCode  |
|Traversal| hi    | invalidCode  |
|Insertion|  | invalidCode  |
|Insertion| hi    | invalidCode  |
|Deletion| EMPTY | invalidCode  |
|Deletion| hi    | invalidCode  |


    Scenario Outline: Verify user is able to see output for valid python code for Arrays in Python page
     When  The user clicks "<LinkedLinks>" in LinkedList page
  When the user clicks the Try Here button on the Linked page
     When The user writes "<dataDrivenColumnHeader>" for "<scenarioType>" in Editor and clicks the Run button
     Then The user should see output in the console for Linkedlist Page

      Examples:
|LinkedLinks|dataDrivenColumnHeader|scenarioType|
|Introduction|LinkedList|validCode|
|Creating Linked List|LinkedList|validCode|
|Types of Linked List|LinkedList|validCode|
|Implement Linked List in Python|LinkedList|validCode|
|Traversal|LinkedList|validCode|
|Insertion|LinkedList|validCode|
|Deletion| LinkedList|validCode|

    