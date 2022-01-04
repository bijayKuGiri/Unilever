Feature: Validate the foodpanda image redirection

  @P1
  @singapore
  @needToUpdate
  Scenario: Verify foodpanda navigation is working
    Given The site is Up and Running
    And user redirected to Magnum Delivery page
    When user click on Foodpanda image
    Then it should open foodpanda in next tab