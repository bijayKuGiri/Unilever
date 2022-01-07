Feature: Validate the UberEats link navigation is working

  @P1
  @Poland
  @All
  @needToUpdate
  Scenario: Verify UberEats link navigation is working
    Given The site is Up and Running
    And user redirected to PDP page
    When click on Uber Eats link
    Then it should open Uber Eats site in next tab