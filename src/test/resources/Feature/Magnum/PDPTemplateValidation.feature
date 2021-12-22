Feature: Validate the PDP Page template

  @P1
  @imageNavigation
  @thailand
  @brazil
  @magnum
  Scenario: Verifying Product Details Template
    Given The site is Up and Running
    When i navigate to a PDP page
    Then Product Details should be displayed

