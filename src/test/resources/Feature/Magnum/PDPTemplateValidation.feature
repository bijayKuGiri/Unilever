Feature: Validate the PDP Page template

  @thailand
  @brazil
  @magnum
  Scenario: Verifying Product Details Template
    Given The site is Up and Running
    When i navigate to a PDP page
    Then Product Details should be displayed

