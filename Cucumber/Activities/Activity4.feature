
@activity4
Feature: Login to the page

  Scenario: parameteriztion without Example 
    Given Load the login page
    When Enter the "admin" and "password"
    Then Read the page title and confirmation message1
    And Close the login browser
 



