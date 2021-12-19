Feature: Validate the Youtube link

  @social
  @magnum
  @thailand
  Scenario: Verifying Youtube link navigation
    Given The site is Up and Running
    When i try to click on Youtube link
    Then the page should redirect to Youtube Page