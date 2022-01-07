Feature: Validate the Cookie consent

  @P0
  @All
  @popup
  @thailand
  @magnum
  @brazil
  Scenario: Verifying cookie consent
    Given The site is Up
    When verify the bottom for cookie popup
    Then it should be visible once the page got loaded

  @P0
  @All
  @popup
  @thailand
  @magnum
  @brazil
  Scenario: Verifying cookie consent functionality
    Given The site is Up
    And the cookie popup is visible
    When click on the accept all button
    Then the popup should disable