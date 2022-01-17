Feature: Validate the Language Option

  @LanguageSwitcher
  @All
  @P0
  @footer
  @thailand
  @magnum
  Scenario: Verifying Language navigation functionality
    Given The site is Up and Running
    When click on the language selector in button
    Then the selected language should be changed in the page.