Feature: Validate the Cookie consent for Reject


  @CookieConsent @P0  @All @thailand  @magnum
  Scenario:Verifying reject functionality cookie consent
    Given The site is Up
    And verify the bottom for cookie popup
    When Click on Reject all button
    Then cookie popup should disappear