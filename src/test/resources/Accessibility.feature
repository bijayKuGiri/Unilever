#Feature: Validate Contact Us for Accessibility
#
#  Scenario Outline: Verifying contact us page using keyboard
#    Given The site is Up and Running
#    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment> using keyboard
#    Then user should get appropriate message based on <Criteria> Criteria
#
#    Examples:
#
#      | name | lastname | email         | comment             | Criteria |
#      | Test | Testing  | test@test.com | For Testing Purpose | Valid    |
#
#
#  Scenario Outline: Verifying contact us page for Empty FirstName using keyboard
#    Given The site is Up and Running
#    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment> using keyboard
#    Then user should get appropriate message based on <Criteria> Criteria
#
#    Examples:
#
#      | name | lastname | email         | comment             | Criteria    |
#      |      | Testing  | test@test.com | For Testing Purpose | NameMissing |
#
#
#  Scenario Outline: Verifying contact us page Empty Last Name using
#    Given The site is Up and Running
#    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment> using keyboard
#    Then user should get appropriate message based on <Criteria> Criteria
#
#    Examples:
#
#      | name | lastname | email         | comment             | Criteria        |
#      | Test |          | test@test.com | For Testing Purpose | lastnameMissing |
#
#
#  Scenario Outline: Verifying contact us page Empty Email
#    Given The site is Up and Running
#    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment> using keyboard
#    Then user should get appropriate message based on <Criteria> Criteria
#
#    Examples:
#
#      | name | lastname | email | comment             | Criteria     |
#      | Test | Testing  |       | For Testing Purpose | emailMissing |
#
#
#
#  Scenario Outline: Verifying contact us page for Empty Comment using keyboard
#    Given The site is Up and Running
#    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment> using keyboard
#    Then user should get appropriate message based on <Criteria> Criteria
#
#    Examples:
#
#      | name | lastname | email         | comment | Criteria       |
#      | Test | Testing  | test@test.com |         | commentMissing |
#
#
#  Scenario Outline: Verifying contact us page for wrong Email using keyboard
#    Given The site is Up and Running
#    When using keyboard navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment>
#    Then user should get appropriate message based on <Criteria> Criteria
#
#    Examples:
#
#      | name | lastname | email        | comment             | Criteria     |
#      | Test | Testing  | testtest.com | For Testing Purpose | inValidEmail |
#
#
#  Scenario Outline: Verifying contact us page without age confirm using keyboard
#    Given The site is Up and Running
#    When navigate to contact us page and without Age confirmation fill the details <name>,<lastname>,<email> and <comment> using keyboard
#    Then user should get appropriate message based on <Criteria> Criteria
#
#    Examples:
#      | name | lastname | email         | comment             | Criteria          |
#      | Test | Testing  | test@test.com | For Testing Purpose | ageConfirmMissing |


