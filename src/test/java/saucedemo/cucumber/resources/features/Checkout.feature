Feature: Checkout Cart

  Scenario: Checkout Empty Cart
    Given List product page saucedemo
    When User click empty cart icon
    Then Page Your Cart is displayed
    And User click checkout button
    Then Error message cart cannot empty