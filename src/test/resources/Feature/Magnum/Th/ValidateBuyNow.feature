Feature: Validate the BuyNow Option

  @BuyNow @All @P0 @footer @thailand @magnum
  Scenario: Verifying BuyNow functionality
    Given The site is Up and Running
    When click on the buy now button in product carousal
    Then the respective page should be open.

  @BuyNow @All @P0 @footer @thailand @magnum
  Scenario: Verifying Shop now functionality using vendor
    Given The site is Up and Running
    And click on the buy now button in product carousal
    When Select the vendor from the list
    Then it should redirect to the vendor page

