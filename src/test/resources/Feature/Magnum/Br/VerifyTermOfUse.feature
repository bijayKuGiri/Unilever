Feature: Validate the TermOfUse link

  @brazil
  @magnum
  Scenario: Verifying TermsOfUse link navigation
    Given The site is Up and Running
    When i try to click on TermsOfUse link in home page
    Then page should redirect to TermOfUse page