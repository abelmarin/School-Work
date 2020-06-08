package edu.depaul.se433.functional;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Demonstrate maven's handling of IT (integration test) classes.
 * The naming convention is used by the failsafe plugin to 
 * identify integration tests.  It runs them later in the build
 * life cycle.
 */
public class DemoIT {

	@Test
	public void verify_I_run_later() {
		System.out.println("\n\n\n*** Running an IT test!\n\n\n");
		assertTrue(true);
	}

}
