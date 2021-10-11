Feature: Verifying Back To Start functionality

  Scenario: Verifying Article page redirection
    Given The site is Up and Running
    When i try to click on Back To Start button
    Then the page should redirect to the top of the Home page