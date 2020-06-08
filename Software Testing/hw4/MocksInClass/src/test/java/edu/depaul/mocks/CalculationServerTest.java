package edu.depaul.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationServerTest {

	@Test
	@DisplayName("Should successfully add 2 numbers")
	void addTest() {
		CalculationServer server = new CalculationServer();
		Query add = new Query("ADD", 5, 7);
		Response resp = server.calculate(add);
		assertEquals(12.0, resp.getResult(), 1e-2);
	}

	@Test
	@DisplayName("Should return UNKNOWN_OPERATION when operation has not been implemented")
	void testUnknown() {
		// TODO: 1. execute an unknown operation and verify expected result
		//       2. fix CalculationServer if needed
		CalculationServer server = new CalculationServer();
		Query subtract = new Query("SUBTRACT", 7, 5);
		Response resp = server.calculate(subtract);
		assertEquals(StatusType.UNKNOWN_OPERATION, resp.getStatus());
	}


}

