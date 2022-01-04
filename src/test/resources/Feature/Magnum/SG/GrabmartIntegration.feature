Feature: Validate the Grabmart image redirection

  @P1
  @singapore
  @needToUpdate
  Scenario: Verify Grabmart navigation is working
    Given The site is Up and Running
    When user click on Grabmart image on magnum delivery page
    Then it should open Grabmart in next tab