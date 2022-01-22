
@activity5
Feature: Login to the page

  Scenario: parameteriztion with Example 
    Given Load the LOGIN page
    When enter the "<Username>" and "<Password>"
    Then read the page title and confirmation message1
    And close the login browser
    
Examples:
| Username | Password |
| admin | password |


  
    
 



