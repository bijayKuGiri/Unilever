Feature: Validate Find out More button functionality

  @P1
  @needToUpdate
  @All

  Scenario: Verify Find Out More button functionality
    Given The site is Up and Running
    And navigate to any random Product listing page
    When i try to click on Quick view button for any product
    Then Popup should open on the same tab with Product name, detail and other buttons
    And click on Find out more button, redirected to PDP page