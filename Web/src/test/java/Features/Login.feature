Feature: Test

  @login
  Scenario Outline: Test scenario

    Given User navigate to URL
    When User enter "<username>" and "<password>"
    Then User clicks on login button
    Then User verify home page

    Examples:
      | username                 | password |
      | karthik24annam@gmail.com | 12345678 |

    ##################