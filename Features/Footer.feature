Feature: Footer Functionality

  Scenario: Check whether footer is displayed
    Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "standard_user" and password as "secret_sauce"
    And click on login
    Then User should see the footer
    And close the browser