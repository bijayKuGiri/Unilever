Feature: Verify FAQ page

  Scenario: Verifying FAQ page navigation and functionality
    Given The site is Up and Running
    And navigate to FAQ page
    When i try to click on + icon
    Then the answer should be visible
    When i try to click on cross * icon
    Then the answer should be hidden again