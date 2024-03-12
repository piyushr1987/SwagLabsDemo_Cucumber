Feature: Cart functionality

Background: steps common for all scenerios
 Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "standard_user" and password as "secret_sauce"
    And click on login

Scenario: Check whether user can see the cart badge get updated when add items to cart
    And click on add to cart
    Then User should see the updated cart badge
    And close the browser
    
 Scenario: Check whether user can see the remove button when add items to cart
    And click on add to cart
    Then User should see the remove buttons
    
  Scenario: Check whether user can see the full product view
    And click on product
    Then User should see the full product view
    
  Scenario: Check whether user can see the cart items added to cart
    And click on add to cart
    And click on cart
    Then User should see the cart items added to cart
    
  Scenario: Check whether user can remove cart items from cart
    And click on add to cart
    And click on cart
    And click on remove
    Then User should see the cart without removed item
    
  Scenario: Check whether user can go to products when full product view
    And click on product
    And click on Back To Products
    Then User should see the product page and URL should be "https://www.saucedemo.com/inventory.html"
    
  Scenario: Check whether user can go to shop from cart
    And click on add to cart
    And click on cart
    And click on continue shopping
    Then User should see the product page and URL should be "https://www.saucedemo.com/inventory.html"
    
  Scenario: Check whether user can go to checkout from cart
    And click on add to cart
    And click on cart
    And click on checkout
    Then User should see the checkout info page and URL should be "https://www.saucedemo.com/checkout-step-one.html"