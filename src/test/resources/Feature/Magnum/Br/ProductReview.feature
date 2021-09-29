Feature: Validate the Product Review

  Scenario: Verifying Product Review section
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    Then it should navigate to Product Review Page Page