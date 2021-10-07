Feature: Validate the Search

  @brazil
  @magnum
  Scenario: Verifying Product search
    Given The site is Up and Running
    When i navigate to search page and search for a product
    Then it should shows the products in Results


  @brazil
  @magnum
  Scenario: Verifying Product search for an wrong product
    Given The site is Up and Running
    When i navigate to search page and search for a  wrong product
    Then it should not shows any products in Results