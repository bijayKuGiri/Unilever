Feature: Validate the VK link

  @P1
  @All
  @social
  @russia
  @needToUpdate
  Scenario: Verifying VK link navigation
    Given The site is Up and Running
    When i try to click on VK icon
    Then the page should redirect to VK page