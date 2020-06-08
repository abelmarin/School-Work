package edu.depaul.shipping;

public class CostCalculator {

  public static double calculate(double initialCost, String location, String shippingType) {

    double newCost = initialCost;
    if (shippingType.equals("StandardShipping")) {
      newCost += 10.0;
    }

    return newCost;
  }

}
