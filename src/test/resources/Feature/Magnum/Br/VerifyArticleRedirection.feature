Feature: Validate the Article Page Redirection
  @Pagelist
  @P0
  @All
  @brazil
  @magnum
  @finland
  Scenario: Verifying Article page redirection using image
    Given The site is Up and Running
    And navigate to the Article Page
    When i click on any article image
    Then it should redirect to Article page