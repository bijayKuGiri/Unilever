Feature: Validate the BuyNow Option

  @BuyNow
  @All
  @P0
  @footer
  @thailand
  @magnum
  Scenario: Verifying Buynow functionality
    Given The site is Up and Running
    When click on the buy now button in product carousal
    Then the respective page should be open.