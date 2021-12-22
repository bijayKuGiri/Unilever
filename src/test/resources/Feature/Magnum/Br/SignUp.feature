Feature: Validate the Sign Up

  @P1
  @footer
  @brazil
  @magnum
  Scenario: Verifying signup functionality
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details and submit
    Then it should submit and redirect to confirmation page.

    @P1
  @footer
  @brazil
  @magnum
  Scenario: Verifying signup functionality without name
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without name and submit
    Then it should display validation message with respect to name

  @P1
  @footer
  @brazil
  @magnum
  Scenario: Verifying signup functionality without lastname
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without lastname and submit
    Then it should display validation message with respect to lastname

  @P1
  @footer
  @brazil
  @magnum
  Scenario: Verifying signup functionality without Email
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without email and submit
    Then it should display validation message with respect to email

  @P1
  @footer
  @brazil
  @magnum
  Scenario: Verifying signup functionality without DOB
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without DOB and submit
    Then it should display validation message with respect to DOB

  @P1
  @footer
  @brazil
  @magnum
  Scenario: Verifying signup functionality without name
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without zipcode and submit
    Then it should display validation message with respect to zipcode