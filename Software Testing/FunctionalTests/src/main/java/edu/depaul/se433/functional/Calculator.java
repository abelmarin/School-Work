package edu.depaul.se433.functional;

/**
 * Simple classs to demonstrate parameterized tests.
 * @see CalculatorTest
 */
public class Calculator {
	
	private int buffer;

	public long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public double peanutPrice(int day, int age, double amount) {
		
		double basePrice = amount * 7.0;
		double finalPrice = 0.0;
		if (age >= 65) {
			finalPrice = basePrice - (basePrice * 0.25);
		} else {
			if (day == 6) {
				basePrice = amount * 6.5;
			}
			if (amount >= 10.0) {
				finalPrice = basePrice - (basePrice * 0.1);
			} else {
				finalPrice = basePrice;
			}
		}
		return finalPrice;
	}
}
