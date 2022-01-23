Feature: Validate the product carousel
  @ProductCarousel
  @P0
  @All
  @brazil
  @magnum
  @thailand
  @finland
  Scenario: Verifying product carousel available
    Given The site is Up and Running
    When verifying the product carousel rotation
    Then product carousel should be work as expected