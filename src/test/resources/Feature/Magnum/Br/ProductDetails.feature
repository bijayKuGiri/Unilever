Feature: Validate the Product Details

  @P0
  @imageNavigation
  @brazil
  @magnum
  Scenario: Verifying Product details available
    Given The site is Up and Running
    When verifying the Products
    Then it should navigate to Product Details Page