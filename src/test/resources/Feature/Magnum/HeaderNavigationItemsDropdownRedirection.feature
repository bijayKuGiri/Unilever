Feature: Validate the Header Navigation Dropdowns redirection

  @P0
  @All
  @UnitedStates
  @Austria
  @France
  @Germany
  @Ireland(UK)
  @Netherland
  @Poland
  @Romania
  @Spain
  @Swiden
  @Switzerland
  @Turkey
  @UnitedKingdom
  @Indonesia
  @needToUpdate

  Scenario: Verify Header Navigation Dropdown values redirection
    Given The site is Up and Running
    When User hover on Header navigation item
    Then Dropdown values should be visible and clickable