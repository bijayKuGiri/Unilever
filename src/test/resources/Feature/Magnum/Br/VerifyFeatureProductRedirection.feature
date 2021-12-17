Feature: Validate the Article Page Redirection

  @P0
  @imageNavigation
  @brazil
  @magnum
  Scenario: Verifying Article page redirection using image
    Given The site is Up and Running
    And navigate to the Article Page
    When i click on any article image
    And click on feature product link
    Then it should redirect to Feature product Page