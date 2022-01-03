Feature: Validate the Frisco.pl link navigation is working

  @P1
  @Poland
  Scenario: Verify Frisco.pl link navigation is working
    Given The site is Up and Running
    When user redirected to PDP page and click on Frisco.pl link
    Then  it should open Firsco.pl site in next tab