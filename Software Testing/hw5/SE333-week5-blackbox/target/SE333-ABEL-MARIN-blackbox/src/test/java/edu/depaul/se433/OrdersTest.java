package edu.depaul.se433;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.depaul.se433.Orders.ShippingMethod;
import static edu.depaul.se433.Orders.ShippingMethod.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class OrdersTest {
  // Problem 2: meets requirements for weak normal test
  @ParameterizedTest
  @CsvFileSource(resources = "/weakNormalOrders.csv", numLinesToSkip = 1)
  void compareOrdersWeakNormal(double rawTotal, ShippingMethod shippingMethod, String destinationState, double expectedTotal) {
    double calculated = Orders.calculateTotal(rawTotal, shippingMethod, destinationState);
    assertEquals(calculated, expectedTotal);
  }

  // Problem 3: meets requirements for weak robust test
  @ParameterizedTest
  @CsvFileSource(resources = "/weakRobustOrders.csv", numLinesToSkip = 1)
  void compareOrdersWeakRobust(double rawTotal, ShippingMethod shippingMethod, String destinationState, double expectedTotal) {
    double calculated = Orders.calculateTotal(rawTotal, shippingMethod, destinationState);
    assertEquals(calculated, expectedTotal);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/weakRobustOrdersInvalid.csv", numLinesToSkip = 1)
  void compareOrdersWeakRobustInvalid(double rawTotal, ShippingMethod shippingMethod, String destinationState) {
    assertThrows(IllegalArgumentException.class, () -> Orders.calculateTotal(rawTotal, shippingMethod, destinationState));
  }

  // Problem 4: meets requirements for strong normal test
  @ParameterizedTest
  @CsvFileSource(resources = "/strongNormalOrders.csv", numLinesToSkip = 1)
  void compareOrdersStrongNormal(double rawTotal, ShippingMethod shippingMethod, String destinationState, double expectedTotal) {
    double calculated = Orders.calculateTotal(rawTotal, shippingMethod, destinationState);
    assertEquals(calculated, expectedTotal);
  }

  // Problem 5: meets requirements for strong robust test
  @ParameterizedTest
  @CsvFileSource(resources = "/strongRobustOrders.csv", numLinesToSkip = 1)
  void compareOrdersStrongRobust(double rawTotal, ShippingMethod shippingMethod, String destinationState, double expectedTotal) {
    double calculated = Orders.calculateTotal(rawTotal, shippingMethod, destinationState);
    assertEquals(calculated, expectedTotal);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/strongRobustOrdersInvalid.csv", numLinesToSkip = 1)
  void compareOrdersStrongRobustInvalid(double rawTotal, ShippingMethod shippingMethod, String destinationState) {
    assertThrows(IllegalArgumentException.class, () -> Orders.calculateTotal(rawTotal, shippingMethod, destinationState));
  }

  // Problem 6: boundary values related to rawTotal
  @Test
  @DisplayName("Boundary Test for rawTotal less than 0")
  void rawTotalLessThan0() {
    assertThrows(IllegalArgumentException.class, () -> Orders.calculateTotal(-10, Standard, "IL"));
  }

  @Test
  @DisplayName("Boundary Test for rawTotal 0")
  void rawTotal0() {
    assertThrows(IllegalArgumentException.class, () -> Orders.calculateTotal(0, Standard, "IL"));
  }

  @Test
  @DisplayName("Boundary Test for rawTotal $50")
  void rawTotal50() {
    double calculated = Orders.calculateTotal(50, Standard, "WA");
    assertEquals(calculated, 60);
  }

  @Test
  @DisplayName("Boundary Test for rawTotal $50.01")
  void rawTotal5001() {
    double calculated = Orders.calculateTotal(50.01, Standard, "WA");
    assertEquals(calculated, 50.01);
  }

  //There is no stated max value therefore I will not test this boundary

}
