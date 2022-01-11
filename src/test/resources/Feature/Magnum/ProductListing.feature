Feature: Validate the Product Listing Page template
  @Template
  @P1
  @thailand
  @brazil
  @magnum
  @All
  Scenario: Verifying Product Listing Details Template
    Given The site is Up and Running
    When I navigate to a Product Listing page
    Then Product Listing Details should be displayed