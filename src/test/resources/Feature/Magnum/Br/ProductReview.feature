Feature: Validate the Product Review


  Scenario: Verifying Product Review section
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the Details
    Then it should navigate to Product Review Page


  Scenario: Verifying Product Review section without Rating
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without Rating
    Then it should display validation message for Rating


  Scenario: Verifying Product Review section without Review Title
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without Review Title
    Then it should display validation message for Review Title

  Scenario: Verifying Product Review section without Nick Name
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without Nick Name
    Then it should display validation message for Nick Name


  Scenario: Verifying Product Review section without Email
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without Email
    Then it should display validation message for Email


  Scenario: Verifying Product Review section with wrong Email
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details with wrong email
    Then it should display validation message for Email


  Scenario: Verifying Product Review section without Agreement
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without agreement
    Then it should display validation message for agreement