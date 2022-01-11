Feature: Validate the Search

  @Search
  @P0
  @brazil
  @All
  @magnum
  @thailand
  Scenario: Verifying Product search for a correct product
    Given The site is Up and Running
    When i navigate to search page and search for a product
    Then it should shows the products in Results

  @Search
  @P1
  @All
  @brazil
  @magnum
  @thailand
  Scenario: Verifying Product search for an wrong product
    Given The site is Up and Running
    When i navigate to search page and search for a  wrong product
    Then it should not shows any products in Results