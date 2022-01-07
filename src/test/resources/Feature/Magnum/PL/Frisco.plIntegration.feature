Feature: Validate the Frisco.pl link navigation is working

  @P1
  @All
  @Poland
  @needToUpdate
  Scenario: Verify Frisco.pl link navigation is working
    Given The site is Up and Running
    And user redirected to PDP page
    When click on Frisco.pl link
    Then it should open Firsco.pl site in next tab