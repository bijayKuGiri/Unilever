Feature: Validate Product Quick View button functionality

  @P0

  Scenario: Verify Product Quick View button functionality
    Given The site is Up and Running
    When navigate to any Product listing pages and i try to click on Quick view button for any product
    Then Popup should open on the same tab with Product name, detail and other buttons