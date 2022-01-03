Feature: Validate the foodpanda image redirection

  @P1
  @singapore
  Scenario: Verify foodpanda navigation is working
    Given The site is Up and Running
    When user click on Foodpanda image on magnum delivery page
    Then it should open foodpanda in next tab