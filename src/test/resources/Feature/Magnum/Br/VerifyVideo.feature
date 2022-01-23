Feature: Validate the video element

  @Video
  @P0
  @brazil
  @magnum
  @All
  @finland
  Scenario: Verifying Video element in the Application
    Given The site is Up and Running
    And navigate to the video contain tab
    When i try to play the video
    Then the video should visible