Feature: Validate the product tab

  @P1
  @brazil
  @magnum
  @thailand
  Scenario: Verifying product tabs
    Given The site is Up and Running
    And navigate to Product tab switch
    When try to click on Product next tab
    Then it should be switched to Next Product tab