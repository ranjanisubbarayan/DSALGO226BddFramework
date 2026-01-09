@Stack 
Feature: Stack Module Tests 

Background:
  Given The user is logged into DS Algo Portal
  
Scenario: Verify that user is able to navigate to Stack data structure page 
When The user clicks the Getting Started button in Stack Panel OR The user select Stack item from the drop down menu 
Then The user be directed to Stack Data Structure Page 

Scenario: Navigate to Operations in Stack
When The user clicks the Getting Started button in Stack Panel
When The user clicks Operations in Stack button
Then The user should be redirected to Operations in Stack page

Scenario: Verify that user is able to navigate to "try Editor" page for "Operations in Stack" page 
Given  user navigates to Operations in Stack page 
When The user clicks Try Here button in Operations in Stack page 
Then The user should be redirected to a page having an try Editor with a Run button to test 

Scenario: Verify that user receives error when click on Run button without entering code for "Operations in Stack" page 
Given The user is in the tryEditor page 
When The user clicks the Run Button without entering the code in the Editor 
Then The user should able to see an error message in alert window

Scenario: Verify that user receives error for invalid input for "Operations in Stack" page 
Given The user is in the tryEditor page 
When The user write the invalid "code" in Editor and click the Run Button 
| code            |
| print hello     |
| print 5+8'  |
Then The user should able to see an error message in alert window 
      
Scenario: Verify that user is able to see output for valid code for "Operations in Stack" page 
Given The user is in the tryEditor page 
When The user write the valid "code" in Editor and click the Run Button 
| code           |
| print("hello") |
| print(40+60)   |
Then The user should able to see output in the console 

Scenario: Verify that user is able to navigate to "Practice Questions" Page for "Implementation" page
Given The user is logged into DS Algo Portal
Given The user is on the Implementation page
When The user clicks Practice Questions button
Then The user should be redirected to Practice page


 
 Scenario: Verify that user is able to navigate to "Implementation" page 
 Given The user is in the Stack page after Sign in 
 When The user clicks Implementation button 
 Then The user should be redirected to Implementation page 
 
 Scenario: Verify that user is able to navigate to "try Editor" page for "Implementation" page 
 Given The user is on the Implementation page 
 When The user clicks Try Here button in Implementation page  
 Then The user should be redirected to a page having an try Editor with a Run button to test 
 
 Scenario: Verify that user receives error when click on Run button without entering code for "Implementation" page
 Given The user is in the tryEditor page 
 When The user clicks the Run Button without entering the code in the Editor 
 Then The user should able to see an error message in alert window 
 
 Scenario: Verify that user receives error for invalid input for "Implementation" page 
 Given The user is in the tryEditor page 
 When The user write the invalid "code" in Editor and click the Run Button 
| code            |
| print hello     |
| print 5+8'  |
 Then The user should able to see an error message in alert window 
 

  Scenario: Verify that user is able to see output for valid code for "Implementation" page 
  Given The user is in the tryEditor page 
  When The user write the valid "code" in Editor and click the Run Button 
| code           |
| print("hello") |
| print(10+20)   |
Then The user should able to see output in the console 

   
  Scenario: Verify that user is able to navigate to "Practice Questions" Page for "Implementation" page 
  Given The user is in the Stack page after Sign in 
  When The user clicks Practice Questions button 
  Then The user should be redirected to Practice page 
  
  Scenario: Verify that user is able to navigate to "Applications" page 
  Given The user is in the Stack page after Sign in 
  When The user clicks Applications button 
  Then The user should be redirected to Applications page 
  
  Scenario: Verify that user is able to navigate to "try Editor" page for "Applications" page
  Given The user is on the Applications page 
  When The user clicks Try Here button in Applications page 
  Then The user should be redirected to a page having an try Editor with a Run button to test 
  
  Scenario: Verify that user receives error when click on Run button without entering code for "Applications" page 
  Given The user is in the tryEditor page 
  When The user clicks the Run Button without entering the code in the Editor 
  Then The user should able to see an error message in alert window 
  
  Scenario: Verify that user receives error when click on Run button entering invalid code for "Applications" page 
  Given The user is in the tryEditor page 
  When The user write the invalid "code" in Editor and click the Run Button
  | code            |
  | print hello     |
  | print 5+18' |

  Then The user should able to see an error message in alert window 
  
  Scenario: Verify that user is able to see output for valid code for "Applications" page 
  Given The user is in the tryEditor page 
  When The user write the valid "code" in Editor and click the Run Button 
| code           |
| print("hello") |
| print(1250+20)   |
Then The user should able to see output in the console 


  Scenario: Verify that user is able to navigate to "Practice Questions" Page for "Applications" page 
  Given The user is in the Stack page after Sign in 
  When The user clicks Practice Questions button 
  Then The user should be redirected to Practice page
  
  
  Scenario Outline: Stack module tryEditor test data using Excel data
    Given I read stack Tryeditor test data for "<testId>"
    When I enter the phythonTryEditor details from excel
    Then I should see output

  Examples:
    | testId | 
    | TC001  | 
    | TC002  |
  