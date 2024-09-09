Feature: Test

  @productSearch
  Scenario Outline: Test scenario

    Given User navigate to URL
    When User enters the product what is looking for"<products>"
    Then User verifies the page


    Examples:
      | products        |
      | clothes for men |

    ##################