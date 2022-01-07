Feature: Validate Product Quick View button functionality

  @P1
  @needToUpdate
  @All
  Scenario: Verify Product Quick View button functionality
    Given The site is Up and Running
    And navigate to any random Product listing page
    When  i try to click on Quick view button for any product
    Then Popup should open on the same tab with Product name, detail and other buttons