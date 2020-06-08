package edu.depaul.mocks;


import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationClientTest {

	@Test
	@DisplayName("When calculation is successful, returns value produced by server(")
	void testSuccessfulAdd() {
		
		CalculationServer mockServer = mock(CalculationServer.class);
		when(mockServer.calculate(any(Query.class))).thenReturn(new Response(StatusType.OK, 25.0));
		
		Logger logger = new SystemLogger();
		CalculationClient client = new CalculationClient(mockServer, logger);
		double result = client.add(0.0, 0.0);  // just to prove client isn't adding for itself
		assertEquals(25.0, result, 1e-2);
	}



	/**
	 * Verify that when the server returns an error Response, the client
	 * logs it.  We also get a RuntimeException under these conditions.
	 */
	@Test
	@DisplayName("When calculation fails, the client logs the result")
	public void testLogResult() {
		// TODO: finish this test
		CalculationServer mockServer = mock(CalculationServer.class);
		when(mockServer.calculate(any(Query.class))).thenReturn(new Response(StatusType.INTERNAL_ERROR, "Error"));

		Logger mockLogger = mock(Logger.class);

		CalculationClient client = new CalculationClient(mockServer, mockLogger);
		try {
			double result = client.divide(5.0, 0.0);
		} catch (Exception e) {}

		verify(mockLogger).log(any());
	}
	

	@Test
	@DisplayName("examine a mock")
	void examineMock() {
		CalculationServer mockServer = mock(CalculationServer.class);
		mockServer.calculate(new Query("XOR", 1.0, 2.0));
		String secret = mockServer.getSecret();

		// put a break point on line below so you can examine the mock server
		System.out.println("pause");
	}

	@Test
	@DisplayName("Demonstrate mockito thenThrow")
	void demoThenThrow() {
		CalculationServer mockServer = mock(CalculationServer.class);
		when(mockServer.calculate(any(Query.class))).thenThrow(new RuntimeException("failed"));
		
		assertThrows(RuntimeException.class, () -> mockServer.calculate(new Query("stuff", 1, 1)));
	}
}
