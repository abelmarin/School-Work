package edu.depaul.mocks;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DemoMocks {

	@Test
	void demoMocks() {
		CalculationServer realServer = new CalculationServer();
		CalculationServer mockServer = mock(CalculationServer.class);
		when(mockServer.getSecret()).thenReturn("mock secret");
		String mockSecret = mockServer.getSecret();
		String realSecret = realServer.getSecret();
		System.out.println("Mock secret: " + mockSecret);
		System.out.println("Real secret: " + realSecret);
	}

}
