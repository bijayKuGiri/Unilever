Feature: Validate the CookiesNotice link in ContactUs Page

  @footer
  @brazil
  @magnum
  Scenario: Verifying CookiesNotice link navigation in Contact Us Page
    Given The site is Up and Running
    And Navigate to Contactus Page
    When i try to click on CookiesNotice link
    Then the page should redirect to CookiesNotice page