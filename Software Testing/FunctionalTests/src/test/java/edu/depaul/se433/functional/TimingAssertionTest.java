package edu.depaul.se433.functional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

import static java.time.Duration.ofMillis;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Demonstrate Junit 5 assertion timeouts.  Note that 
 * the improvement is that we can target the specific 
 * action to time, where the other timeout techniques
 * apply to the entire test function.
 */
class TimingAssertionTest {

	@Test
	@Tag("TIMING")
	@DisplayName("Verify that assertTimeout works as expected")
	public void verify_timeout_works() {
		assertTimeout(ofMillis(20), () -> Thread.sleep(10));
	}
	
	@Test
	@Tag("TIMING")
	public void verify_timeout_works_with_function_ref() {
		assertTimeout(ofMillis(20), TimingAssertionTest::pause);
	}
	
	public static void pause() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
