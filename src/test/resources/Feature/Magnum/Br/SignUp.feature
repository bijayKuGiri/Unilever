Feature: Validate the Sign Up

  @SignUp
  @P0
  @footer
  @brazil
  @magnum
  @All
  Scenario: Verifying signup functionality
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details and submit
    Then it should submit and redirect to confirmation page.

  @SignUp
  @P1
  @footer
  @brazil
  @magnum
  @All
  Scenario: Verifying signup functionality without name
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without name and submit
    Then it should display validation message with respect to name

  @SignUp
  @P1
  @footer
  @brazil
  @magnum
  @All
    Scenario: Verifying signup functionality without lastname
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without lastname and submit
    Then it should display validation message with respect to lastname

  @SignUp
  @P1
  @All
  @footer
  @brazil
  @magnum
  Scenario: Verifying signup functionality without Email
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without email and submit
    Then it should display validation message with respect to email

  @SignUp
  @P1
  @All
  @footer
  @brazil
  @magnum
  Scenario: Verifying signup functionality without DOB
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without DOB and submit
    Then it should display validation message with respect to DOB
\
  @SignUp
  @P1
  @footer
  @brazil
  @magnum
  @All
  Scenario: Verifying signup functionality without zipcode
    Given The site is Up and Running
    And navigate to signup page
    When enter all the details without zipcode and submit
    Then it should display validation message with respect to zipcode