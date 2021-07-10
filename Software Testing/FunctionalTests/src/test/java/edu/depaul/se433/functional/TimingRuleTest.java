package edu.depaul.se433.functional;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Demonstrate the use of a global timing Rule.  
 * Change the rule to smaller values to see what 
 * happens.  Why isn't 2000 millis enough time for
 * a_slow_test?
 */
public class TimingRuleTest {
	
	@Rule
	public Timeout globalTimeout = Timeout.millis(20000);
	
	@Before
	public void setup() throws InterruptedException {
		// demonstrate that setup is timed as well
		Thread.sleep(600);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		// demonstrate that teardown is timed as well
		Thread.sleep(600);
	}

	@Test
	public void a_fast_test() throws InterruptedException {
		Thread.sleep(100);
	}
	
	@Test
	public void a_slow_test() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	@Test
	@Ignore
	public void a_medium_test() throws InterruptedException {
		Thread.sleep(500);
	}

}
