@activity1_2
Feature: Login Test


Scenario: testing of Login screen
    Given User is on Login page
    When User Enters Username and Password
    Then Read the page title and confirmation message
    And close the browser

