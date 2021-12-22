Feature: Validate the Twitter link

  @P1
  @social
  @brazil
  @magnum
  @thailand
  Scenario: Verifying Twitter link navigation
    Given The site is Up and Running
    When i try to click on twitter link
    Then the page should redirect to Twitter page