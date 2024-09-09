Feature: Grocery API
@Sample
  Scenario: Get All Products from Grocery
    Given url'https://reqres.in/api'
    And path '/users?page=2'
    When method get
    Then status 200