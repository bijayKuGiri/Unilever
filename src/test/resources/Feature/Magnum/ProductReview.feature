Feature: Validate the Product Review

  @ReviewRating
  @P0
  @thailand
  @brazil
  @All
  @magnum
  Scenario: Verifying Product Review section
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the Details
    Then it should navigate to Product Review Page


  @ReviewRating
  @P1
  @thailand
  @brazil
  @All
  @magnum
  Scenario: Verifying Product Review section without Rating
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without Rating
    Then it should display validation message for Rating

  @ReviewRating
  @P1
  @thailand
  @All
  @brazil
  @magnum
  Scenario: Verifying Product Review section without Review Title
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without Review Title
    Then it should display validation message for Review Title

  @ReviewRating
  @P1
  @thailand
  @brazil
  @All
  @magnum
  Scenario: Verifying Product Review section without Nick Name
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without Nick Name
    Then it should display validation message for Nick Name

  @ReviewRating
  @P1
  @All
  @thailand
  @brazil
  @magnum
  Scenario: Verifying Product Review section without Email
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without Email
    Then it should display validation message for Email

  @ReviewRating
  @P1
  @thailand
  @brazil
  @All
  @magnum
  Scenario: Verifying Product Review section with wrong Email
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details with wrong email
    Then it should display validation message for Email

  @ReviewRating
  @P1
  @thailand
  @All
  @brazil
  @magnum
  Scenario: Verifying Product Review section without Agreement
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without agreement
    Then it should display validation message for agreement

  @ReviewRating
  @P1
  @All
  @thailand
  @brazil
  @magnum
  Scenario: Verifying Product Review section without your Review
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details without your Review
    Then it should display validation message for minimum Your Review

  @ReviewRating
  @P1
  @thailand
  @All
  @brazil
  @magnum
  Scenario: Verifying Product Review section with your Review more than 500 character
    Given The site is Up and Running
    When i navigate to a product and select the Review section
    And Fill the details with your Review more than five hundred char
    Then it should display validation message for maximum Your Review