package edu.depaul.shipping.step_definitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.depaul.shipping.CostCalculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShippingCostSteps {

  private double initialCost;
  private String location;
  private String shippingType;

  @Given("The customer has selected items totalling {double}")
  public void the_customer_has_selected_items_totalling(Double cost) {
    initialCost = cost;
  }

  @Given("the customer lives in {string}")
  public void the_customer_lives_in(String state) {
    location = state;
  }

  @Given("the customer wants {string} shipping")
  public void the_customer_wants(String shipping) {
    if (shipping.startsWith("Standard")) {
      shippingType = "StandardShipping";
    }
  }

  @Then("the final cost is {double}")
  public void the_final_cost_is(Double expectedCost) {
    double finalCost = CostCalculator.calculate(initialCost, location, shippingType);
    assertEquals(expectedCost, finalCost);
  }
}
