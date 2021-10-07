Feature: Validate the carousel

  @brazil
  @magnum
  @SmokeTest
  Scenario: Verifying carousel available
    Given The site is Up and Running
    When verifying the carousel rotation
    Then it should be work as expected