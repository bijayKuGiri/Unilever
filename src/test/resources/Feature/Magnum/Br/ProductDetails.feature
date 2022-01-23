Feature: Validate the Product Details

  @KnowMoreButton @P1 @brazil @magnum @All @finland
  Scenario: Verifying Product details available
    Given The site is Up and Running
    When verifying the Products
    Then it should navigate to Product Details Page