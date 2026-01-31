    @register
    Feature: DS_ALGO_APP Register Page Verification          
    
    Rule: Below scenario covers with Registration module
    
    Background: Given The user is on the user Registration page
    
    Scenario: User navigates to the Register page	 
    Given The user is on the user Registration page	
    When The user clicks the Register link on the Home page	
    Then The user navigates to the Register page
	
	Scenario: Error messages are displayed when all fields are empty  during Registration 
	Given The user is on the user Registration page	
	When The user clicks the Register button with all fields are empty	
	Then The Error message Please fill out this field, Shows under the Username box
	
	Scenario: Error message are displayed when Username field is empty 
	Given The user is on the user Registration page	
	When The userclicks the Register button after entering password and password confirmation with the Username field is empty
	
	 | Password  | Password confirmation |
     | Test@1234 | Test@1234             |	
     
	Then The Error message "Please fill out this field", Shows under the Username box

    Scenario:Error messages are displayed when the Password field is empty  
	Given The user is on the user Registration page	
	When The user clicks the Register button after entering a Username with other fields are empty
	
	| Username	|
	| Abcuser   |
	
	Then The error message "Please fill out this field", Shows under the Password box
			
	Scenario: Error messages are displayed when the Password Confirmation field is empty 
	Given The user is on the user Registration page	
	When The user clicks the Register button after entering a Username and Password with Password confirmation field is empty	
	|  Username | Password |
	| Abcuser   | Test@123 |	
	Then The error message "Please fill out this field", Shows under the Password confirmation box
	
	Scenario: Error message is displayed for Invalid Username 
    Given The user is on the user Registration page	
    When The user clicks the Register button after entering a Username containing space character and invalid symbols other than digits and (./+=_@)) with  password and password confirmation	
    | Username	| Password  | Password confirmation |
    | Abc user$ | Test@1234 | Test@1234             |        
    Then No "error validation message" shows when entered invalid Username field   
    
	Scenario: Error message is displayed for Invalid Password 
    Given The user is on the user Registration page	
    When The user clicks the Register button after entering username with entering a Password and password confirmation consisting only of numeric data
     | Username	| Password  | Password confirmation |
     | user     | 123456789 | 123456789             |   	
    Then No error message shows when entered invalid Password field
     			
	Scenario: Error message is displayed when Password and Password confirmation did not match 
	Given The user is on the user Registration page	
	When The user clicks the Register button after entering a "username" with mismatched password in the "Password" and "Passsword confirmation" fields	
	Then The user sees the warning message "password_mismatch:The two password fields didn’t match."
		
	Scenario: User navigates to the Home page after successful registration with valid inputs 
	Given The user is on the user Registration page	
	When The user clicks the Register button after entering valid Username ,Password and Password confirmation in their respective fields	
	 | Password     | Password confirmation |
     | Password@123 | Password@123          |  
	Then The user goes to DS Algo Home page with the message "New Account Created. You are logged in as <ID>"
	
  Scenario: Register test using Excel data
  Given The user is on the user Registration page
  When  the user generates a new username and writes it into Excel for "<testId>"
  When  the user reads register test data for "<testId>" from Excel
  When the user submits the Register form using Excel data
  Then the user should see the ExpectedResult
    
  Examples:
    | testId |ExpectedResult                                          |
    | TC001  |Please fill out this field                              |
    | TC002  |Please fill out this field                              | 
    | TC003  |Please fill out this field                              | 
    | TC004  |Please fill out this field                              | 
    | TC005  |password_mismatch:The two password fields didn’t match. |
    | TC006  |password_mismatch:The two password fields didn’t match. |
    | TC007  |New Account Created.                                    |
			
			  #----Registration Module Non-Functional Testing---

  Rule: Below scenario covers Registration module Non functional feature
  
  Background: Given The user is on the user Registration page
  
   @nonfunctional @performance
  Scenario: Verify Register page loads within acceptable time
    Given The user is on the user Registration page
    Then Register page should load within "5" seconds

  @nonfunctional @usability
  Scenario: Verify all input fields and submit button are visible
    Given The user is on the user Registration page
    Then all input fields and submit button should be visible

  @nonfunctional @security
  Scenario: Verify Register page uses HTTPS
    Given The user is on the user Registration page
    Then Register page should be loaded using HTTPS

  @nonfunctional @accessibility
  Scenario: Verify keyboard navigation works
    Given The user is on the user Registration page
    Then user should be able to navigate Register page using keyboard

  @nonfunctional @reliability
  Scenario: Refresh Register page
    When The user is on the user Registration page
    Then Register page should load without errors



			

			


			


			
			
		
			
