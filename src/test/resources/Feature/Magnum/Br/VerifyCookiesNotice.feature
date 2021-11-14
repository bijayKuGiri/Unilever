Feature: Validate the CookiesNotice link in Home Page

  @brazil
  @magnum
  Scenario: Verifying CookiesNotice link navigation in Home Us Page
    Given The site is Up and Running
    When i try to click on CookiesNotice link in Home Page
    Then the page should redirect to CookiesNotice page from Home Page