Feature: Validate the Instagram link

  @social
  @magnum
  @thailand
  Scenario: Verifying Instagram link navigation
    Given The site is Up and Running
    When i try to click on Instagram link
    Then the page should redirect to InstagramPage