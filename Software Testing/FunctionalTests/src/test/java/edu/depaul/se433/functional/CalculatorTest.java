package edu.depaul.se433.functional;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Demonstrate the use of Junit5 parameterized tests
 */
public class CalculatorTest {
	
	@ParameterizedTest
	@MethodSource("provideExpectedAndInput")
	@DisplayName("Test the factorial operation against hand calculated values")
    public void testFactorialAgainstExpected(int expected, int input) {
        Calculator calc = new Calculator();
        assertEquals(expected, calc.factorial(input));
    }
	
	private static Stream<Arguments> provideExpectedAndInput() {
	    return Stream.of(
	      Arguments.of(1,    0),
	      Arguments.of(1,    1),
	      Arguments.of(2,    2),
	      Arguments.of(24,   4),
	      Arguments.of(5040, 7)
	    );
	}

	@ParameterizedTest
	@MethodSource("providePeanutInput")
	@DisplayName("Test the peanut pricing function with hand calculated values")
    public void testPeanutPricing(int dayOfPurchase, int age, double peanutsAmount, double expected) {
        Calculator calc = new Calculator();
        assertEquals(expected, calc.peanutPrice(dayOfPurchase, age, peanutsAmount), 1e-2);
    }
	
	private static Stream<Arguments> providePeanutInput() {
	    return Stream.of(
	    	//           day age amt   expected
	      Arguments.of(6,  50, 5.5,  35.75),
	      Arguments.of(6,  80, 35.0, 183.75),
	      Arguments.of(6,  50, 35.0, 204.75),
	      Arguments.of(6,  80, 5.5,  28.87),
	      Arguments.of(3,  50, 5.5,  38.5),
	      Arguments.of(3,  50, 35.0, 220.5),
	      Arguments.of(3,  80, 5.5,  28.87),
	      Arguments.of(3,  80, 35.0, 183.75));
	}
}
