Feature: Validate Quick View button functionality

  @QuickView  @P1  @needToUpdate  @All
  Scenario: Verify Quick View button functionality
    Given The site is Up and Running
    And click on the Quick View button in product carousal
    When i try to click on Find Out More button in Quick View popup
    Then the respective PDP page should be open