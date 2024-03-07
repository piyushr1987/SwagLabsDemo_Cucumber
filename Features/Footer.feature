Feature: Footer Functionality
Background: steps common for all scenerios
 Given User Launch Chrome browser 
    When user open the URL "https://www.saucedemo.com/"
    And user enter the username as "standard_user" and password as "secret_sauce"
    And click on login

 Scenario: Check whether footer is displayed
  Then User should see the footer
  
 Scenario: Check whether footer text is displaying correctly
  Then User should see the footer text as "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"
  
 Scenario: Check whether twitter is working correctly
  And click on twitter
  Then User should navigate to swag labs twitter page
  