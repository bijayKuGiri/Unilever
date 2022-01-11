Feature: Validate the PrivacyNotice link in contact Us page
  @ContactUs
  @footer
  @thailand
  @brazil
  @magnum
  @All
  Scenario: Verifying PrivacyNotice link navigation in contactus page
    Given The site is Up and Running
    And Navigate to ContactUS Page
    When i try to click on PrivacyNotice link
    Then the page should redirect to PrivacyNotice page