Feature: Validate the product carousel

  @brazil
  @magnum
  @thailand
  Scenario: Verifying product carousel available
    Given The site is Up and Running
    When verifying the product carousel rotation
    Then product carousel should be work as expected