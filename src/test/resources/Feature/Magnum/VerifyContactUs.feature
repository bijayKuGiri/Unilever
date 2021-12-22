Feature: Validate Contact Us

    @P1
    @footer
    @magnum
    @brazil
    @thailand
  Scenario Outline: Verifying contact us page
    Given The site is Up and Running
    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment>
    Then user should get message based on <Criteria> Criteria

    Examples:

      | name | lastname | email         | comment             | Criteria |
      | Test | Testing  | test@test.com | For Testing Purpose | Valid    |

  @footer
    @magnum
    @brazil
    @thailand
  Scenario Outline: Verifying contact us page for Empty FirstName
    Given The site is Up and Running
    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment>
    Then user should get message based on <Criteria> Criteria

    Examples:

      | name | lastname | email         | comment             | Criteria    |
      |      | Testing  | test@test.com | For Testing Purpose | NameMissing |

  @footer
    @magnum
    @brazil
    @thailand
  Scenario Outline: Verifying contact us page Empty Last Name
    Given The site is Up and Running
    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment>
    Then user should get message based on <Criteria> Criteria

    Examples:

      | name | lastname | email         | comment             | Criteria        |
      | Test |          | test@test.com | For Testing Purpose | lastnameMissing |

  @footer
    @magnum
    @brazil
    @thailand
  Scenario Outline: Verifying contact us page Empty Email
    Given The site is Up and Running
    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment>
    Then user should get message based on <Criteria> Criteria

    Examples:

      | name | lastname | email | comment             | Criteria     |
      | Test | Testing  |       | For Testing Purpose | emailMissing |


  @footer
    @magnum
    @brazil
    @thailand
  Scenario Outline: Verifying contact us page for Empty Comment
    Given The site is Up and Running
    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment>
    Then user should get message based on <Criteria> Criteria

    Examples:

      | name | lastname | email         | comment | Criteria       |
      | Test | Testing  | test@test.com |         | commentMissing |

  @footer
    @magnum
    @brazil
    @thailand
  Scenario Outline: Verifying contact us page for wrong Email
    Given The site is Up and Running
    When navigate to contact us page and fill the details <name>,<lastname>,<email> and <comment>
    Then user should get message based on <Criteria> Criteria

    Examples:

      | name | lastname | email        | comment             | Criteria     |
      | Test | Testing  | testtest.com | For Testing Purpose | inValidEmail |

  @footer
    @magnum
    @brazil
    @thailand
  Scenario Outline: Verifying contact us page without age confirm
    Given The site is Up and Running
    When navigate to contact us page and without Age confirmation fill the details <name>,<lastname>,<email> and <comment>
    Then user should get message based on <Criteria> Criteria

    Examples:
      | name | lastname | email         | comment             | Criteria          |
      | Test | Testing  | test@test.com | For Testing Purpose | ageConfirmMissing |


