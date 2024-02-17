Feature: Login 

  Scenario: Check the Login Functionality
    Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "standard_user" and password as "secret_sauce"
    And click on login
    Then User should navigate to Swag labs home page and URL should be "https://www.saucedemo.com/inventory.html".
    And close the browser

 