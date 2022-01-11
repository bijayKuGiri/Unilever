Feature: Validate the product nutrition
  @Accordion
  @P0
  @brazil
  @All
  @magnum
  Scenario: Verifying product nutrition details
    Given The site is Up and Running
    And Navigate to a product
    When i try to click on nutrition details
    Then nutrition details should be displayed