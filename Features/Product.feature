Feature: Product
Background: steps common for all scenerios
 Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "standard_user" and password as "secret_sauce"
    And click on login

  Scenario: Check the Product page functionality
    
    Then User should able to see product title label as "Products"
    
 Scenario: Check whether product sort option is displayed
    
   Then User should able to see product sort option
   
 Scenario: Check whether inventory items are displayed correctly
    
   Then User should able to see all inventory items correctly
   
 Scenario: Check whether product sort option ZA is working correctly
    
   Then User should see the ZA sorted products
   
Scenario: Check whether product sort option low to high is working correctly
    
   Then User should see the low to high sorted products
   
Scenario: Check whether product sort option high to low is working correctly
    
   Then User should see the high to low sorted products
   
 Scenario: Check whether product images are displayed correctly
    
   Then User should see the correct products images
   