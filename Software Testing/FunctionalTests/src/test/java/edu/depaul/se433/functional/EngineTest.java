package edu.depaul.se433.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import edu.depaul.se433.functional.Engine.EngineState;

/**
 * Demonstrate executing tests in a specified order.
 * 
 * QUESTION:
 * How can we rewrite the test so that order of tests
 * is no longer important?  Why might that be impractical
 * for some tests?
 * NOTE: 
 * 1. this is not a good idea in a unit test but 
 *    could be necessary in a functional test. 
 * 2. Unlike a unit test, we have a single static instance
 *    of the class under test.    
 */
@TestMethodOrder(OrderAnnotation.class)
public class EngineTest {
	
	private static Engine engine = new Engine();
	
	@Test
	@Order(0)
	@DisplayName("Verify initial state is OFF")
	void verifyInitiallyOff() {
		assertEquals(EngineState.OFF, engine.getState());
	}

	@Test
	@Order(1)
	@DisplayName("Verify start() works from the OFF state")
	public void verifyStart() {
		engine.start();
		assertEquals(EngineState.IDLE, engine.getState());
	}
	
	@Test
	@Order(2)
	@DisplayName("Verify run() works from the IDLE state")
	public void verifyRun() {
		engine.run();
		assertEquals(EngineState.RUNNING, engine.getState());
	}
	
	@Test
	@Order(3)
	@DisplayName("Verify stop() works from the RUNNING state")
	public void verifyStop() {
		engine.stop();
		assertEquals(EngineState.OFF, engine.getState());
	}

}
