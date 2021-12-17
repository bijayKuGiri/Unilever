Feature: Verify Country selector

  @P0
  @brazil
  @magnum
  Scenario:Verify Country selector
    Given The site is Up and Running
    When i try to click on Select Your Country link in footer
    Then the Country Selector page should be displayed