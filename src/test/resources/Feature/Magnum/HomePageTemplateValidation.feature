Feature: Validate the Home Page template

  @Template
  @P1
  @All
  @thailand
  @brazil
  @magnum
  @finland
  Scenario: Verifying Home Page Template
    Given The site is Up and Running
    When Verifying Home Page Template
    Then Home Page Details should be displayed

