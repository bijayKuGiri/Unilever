Feature: Validate the Home Page

  @P1
  @header
  @brazil
  @magnum
  Scenario: Verifying landing page
    Given The site is Up and Running
    When verifying all the links
    Then All the elements should placed appropriately
  