package edu.depaul.se433.functional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Demonstrate 2 ways of insuring all asserts are tried.
 */
class AssertAllTest {

	@Test
	@DisplayName("See if the 2nd test is called using Junit 5 assertAll")
	void testAssertAll() {
		assertAll("some asserts", 
		   () -> {
			   System.out.println("trying test 1");
			   assertEquals(12, 10);
		   },
		   () -> {
		       System.out.println("trying test 2");
		       assertEquals(11, 10);
		   }
		);
	}
}
