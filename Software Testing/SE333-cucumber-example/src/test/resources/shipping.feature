Feature: Shipping cost calculation
  Scenario: standard shipping, no tax, on small purchase
    Given The customer has selected items totalling 30.00
    And the customer lives in "IN"
    And the customer wants "Standard" shipping
    Then the final cost is 40.00

