Feature: Validate the Twitter link

  @SocialShare
  @P1
  @brazil
  @magnum
  @All
  @thailand
  Scenario: Verifying Twitter link navigation
    Given The site is Up and Running
    When i try to click on twitter link
    Then the page should redirect to Twitter page