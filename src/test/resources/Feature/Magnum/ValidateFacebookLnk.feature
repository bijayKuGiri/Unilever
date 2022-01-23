Feature: Validate the facebook link

  @social
  @P1
  @brazil
  @All
  @magnum
  @thailand
  @finland
  Scenario: Verifying facebook link navigation
    Given The site is Up and Running
    When i try to click on facebook link
    Then the page should redirect to facebook page