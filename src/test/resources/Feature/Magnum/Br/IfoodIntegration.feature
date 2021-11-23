Feature: Validate the ifood on carousel

  @brazil
  @magnum
  Scenario: Verifying ifood link available in carousel
    Given The site is Up and Running
    When verifying the ifood link on  carousel
    Then it should navigate to ifood page