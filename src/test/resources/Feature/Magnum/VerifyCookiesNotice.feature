Feature: Validate the CookiesNotice link in Home Page

  @P1
  @footer
  @brazil
  @magnum
  @thailand
  Scenario: Verifying CookiesNotice link navigation in Home Page
    Given The site is Up and Running
    When i try to click on CookiesNotice link in Home Page
    Then the page should redirect to CookiesNotice page from Home Page