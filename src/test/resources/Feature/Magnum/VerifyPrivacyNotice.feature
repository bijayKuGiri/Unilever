Feature: Validate the PrivacyNotice link
  @PrivacyNotice
  @P1
  @footer
  @brazil
  @magnum
  @thailand
  @All
  @finland
  Scenario: Verifying PrivacyNotice link navigation in home page
    Given The site is Up and Running
    When i try to click on PrivacyNotice link in home page
    Then the page should redirect to PrivacyNotice page from home page