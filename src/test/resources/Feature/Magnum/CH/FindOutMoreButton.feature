Feature: Validate Find out More button functionality

  @P0

  Scenario: Verify Find Out More button functionality
    Given The site is Up and Running
    When navigate to any Product listing pages and click on Quick view button for any product
    Then Find out more button should be visible and on click redirected to PDP page