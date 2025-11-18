    @register
    Feature: DS_ALGO_APP Register Page Verification  

    @SC1register
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
	When The user clicks the Register button after entAbcering a Username and Password with Password confirmation field is empty	
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
	Given The user is on the user Registeration page	
	When The user clicks the Register button after entering valid Username ,Password and Password confirmation in their respective fields	
	 | Password     | Password confirmation |
     | Password@123 | Password@123          |  
	Then The user goes to DS Algo Home page with the message "New Account Created. You are logged in as <ID>"
			
			

			

			


			


			
			
		
			
