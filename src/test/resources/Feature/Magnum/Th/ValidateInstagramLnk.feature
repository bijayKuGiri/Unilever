Feature: Validate the Instagram link

  @social
  @All
  @P1
  @magnum
  @thailand
  @finland
  Scenario: Verifying Instagram link navigation
    Given The site is Up and Running
    When i try to click on Instagram link
    Then the page should redirect to InstagramPage