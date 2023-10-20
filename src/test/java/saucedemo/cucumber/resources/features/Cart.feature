Feature: Add Product to Cart

  Scenario: Successfully Add Product to Cart
    Given List product page
    When User click add to cart button
    Then Remove button displayed in selected product
    And Cart icon displayed number of product added
    When User click cart icon
    Then Your Cart page is displayed
    And A list of added products appears
