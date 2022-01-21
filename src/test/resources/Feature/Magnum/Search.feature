Feature: Validate the Search

  @Search @P0 @brazil @All @magnum @thailand
  Scenario: Verifying Product search for a correct product
    Given The site is Up and Running
    When i navigate to search page and search for a product
    Then it should shows the products in Results

  @Search @P0 @brazil @All @magnum @thailand
  Scenario: Verifying Product navigation for searching correct product
    Given The site is Up and Running
    When i navigate to search page and search for a product
    And it should shows the products in Results
    When click on any product of the product list
    Then it should navigate to the product details.

  @Search @P1 @All @brazil @magnum @thailand
  Scenario: Verifying Product search for an wrong product
    Given The site is Up and Running
    When i navigate to search page and search for a  wrong product
    Then it should not shows any products in Results

  @Search @P1 @All @brazil @magnum @thailand
  Scenario: Verifying search suggestion
    Given The site is Up and Running
    When i navigate to search page and search for a  wrong product
    And it should not shows any products in Results
    When click on any product of the suggestion list
    Then it should navigate to the suggestion product details.