Feature: Verify SiteMap Page

  @Sitemap
  @P0
  @footer
  @brazil
  @magnum
  @thailand
  @All
  Scenario: Verify Sitemap Page and Link
    Given The site is Up and Running
    When i try to click on Sitemap link
    And click on any link on sitemap page
    Then the page should redirect to Sitemap page