Feature: Validate logo the Home Page

  @UnileverLogo
  @P0
  @header
  @brazil
  @magnum
  @thailand
  @All
  Scenario: Verifying landing page for logo
    Given The site is Up and Running
    When verifying logo
    Then Logo should be visible