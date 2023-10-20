Feature: Filled checkout information

  Scenario: User filled checkout information with correct format
  Given Checkout page with information user input field
  Then User typed first name
  When User typed last name
  And User typed zip or postal code
  And User click continue button
  Then Checkout overview page displayed
