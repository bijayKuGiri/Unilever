Feature: Validate the Header Navigation Dropdowns redirection

  @P0
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

  Scenario: Verify Header Navigation Dropdown values redirection
    Given The site is Up and Running
    When User hover on Header navigation item
    Then Dropdown values should be visible and clickable