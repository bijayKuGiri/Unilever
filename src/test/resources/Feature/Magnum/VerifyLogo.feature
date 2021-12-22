Feature: Validate logo the Home Page

  @P1
  @header
  @brazil
  @magnum
  @thailand
  Scenario: Verifying landing page for logo
    Given The site is Up and Running
    When verifying logo
    Then Logo should be visible