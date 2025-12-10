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

   Scenario: User views the Data Structures Dropdown Options 
   Given The user is on Home page	
   When  User click the dropdown button	
   Then  The user should able to see six options  Array Linked List Stack Queue Tree Graph in dropdown menu
  
   
   Scenario: when selecting "Data Structure" dropdown menu , its displayed the Error Message  
   Given The user is on Home page	
   When user click the dropdown		
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario: when selecting "Array" dropdown menu , its displayed the Error Message 
   Given The user is on Home page	
   When the user selects Arrays from the dropdown		
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario: when clicking the "Get Started "button for "Data structures - Induction", Its displayed Error message 
   Given The user is on Home page	
   When user click the Get Started button of Data Structure - Induction 
   Then The user should able to see an Warning message "You are not logged in"

   Scenario: when clicking the "Get Started" button for "Arrays", Its displayed Error message 
   Given The user is on Home page	
   When click the Get Started button of Array
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when selecting "Linked List" in thedropdown menu, its displayed Error message 
   Given The user is on Home page	
   When user  select Linked List in the dropdown button	
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario: when selecting  "Stack" in the dropdown menu, its displayed Error mesaage 
   Given The user is on Home page	
   When user select  Stack in the dropdown button 	
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when selecting  "Queue" in the dropdown menu, its displayed Error message 
   Given The user is on Home page	
   When user select Queue in the dropdown button
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when selecting  Tree in the dropdown menu, its displayed Error message
   Given 	The user is on Home page	
   When user select Tree in the dropdown button	
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when selecting  "Graph" in the dropdown menu, its displyed Error message 
   Given The user is on Home page	
   When user select Graph in the dropdown button
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when clicking  the "Get Started" button for "Linked List", its displayed Error message  
   Given 	The user is on Home page	 
   When user click the Get Started button of Linked List 	
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when clicking the "Get Started" button for "Stack", its displayed Error message	 
   Given The user is on Home page	
   When user click the Get Started button of Stack	
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when clicking the "Get Started" button for "Queue" , its displayed Error message 
   Given 	The user is on Home page	
   When user click the Get Started button of Queue
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when clicking the "Get Started" button for "Tree", its displayed Error message 
   Given The user is on Home page	
   When user click the Get Started button of Tree
   Then The user should able to see an Warning message "You are not logged in"
   
   Scenario:when clicking  the "Get Started" button for "Graph", its displayed Error message  
   Given The user is on Home page	
   When user click the Get Started button of Graph
   Then The user should able to see an Warning message "You are not logged in"

   



