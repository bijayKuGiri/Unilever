Feature: Validate the Article Page Redirection

  @Pagelist
  @P0
  @brazil
  @magnum
  @All
  @finland
  Scenario: Verifying Article page redirection using image
    Given The site is Up and Running
    And navigate to the Article Page
    When i click on any article image
    And click on feature product link
    Then it should redirect to Feature product Page