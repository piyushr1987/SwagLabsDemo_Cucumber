Feature: Login 

  Scenario: Check the Login Functionality
    Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "standard_user" and password as "secret_sauce"
    And click on login
    Then User should navigate to Swag labs home page and URL should be "https://www.saucedemo.com/inventory.html".
    And close the browser
    
    Scenario: Successful Login with Valid Credentials DDT
    Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "<username>" and password as "<password>"
    And click on login
    Then User should navigate to Swag labs home page and URL should be "https://www.saucedemo.com/inventory.html".
    And close the browser
    
    Examples:
|username|password|
|standard_user|secret_sauce|
|problem_user|secret_sauce|
|problem_user|admin123|

 Scenario: Display login error messages
    Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "" and password as ""
    And click on login
    Then User should see the correct error message as "Epic sadface: Username is required".
    And close the browser
    
    Scenario: Display login error messages
    Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "standard_user" and password as ""
    And click on login
    Then User should see the correct error message for password field as "Epic sadface: Password is required"
    And close the browser

 