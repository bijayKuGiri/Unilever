Feature: Validate the TermOfUse link in Contact Us

  @brazil
  @magnum
  Scenario: Verifying TermsOfUse link navigation in Contact us page
    Given The site is Up and Running
    And Navigate to Contact US Page
    When i try to click on TermOfUse link
    Then the page should redirect to TermOfUse page