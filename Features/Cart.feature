Feature: Cart functionality

Scenario: Check whether user can see the cart badge get updated when add items to cart
Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "standard_user" and password as "secret_sauce"
    And click on login
    And click on add to cart
    Then User should see the updated cart badge
    And close the browser