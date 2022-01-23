Feature: Validate the PDP Page template

  @Template
  @P1
  @All
  @imageNavigation
  @thailand
  @brazil
  @magnum
  @finland
  Scenario: Verifying Product Details Template
    Given The site is Up and Running
    When i navigate to a PDP page
    Then Product Details should be displayed

