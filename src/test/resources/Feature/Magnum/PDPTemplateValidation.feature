Feature: Validate the PDP Page template

  Scenario: Verifying Product Details Template
    Given The site is Up and Running
    When i navigate to a PDP page
    Then Product Details should be displayed
