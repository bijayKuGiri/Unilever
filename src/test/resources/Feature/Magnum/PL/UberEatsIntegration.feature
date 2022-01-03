Feature: Validate the UberEats link navigation is working

  @P1
  @Poland
  Scenario: Verify UberEats link navigation is working
    Given The site is Up and Running
    When user redirected to PDP page and click on Uber Eats link
    Then  it should open Uber Eats site in next tab