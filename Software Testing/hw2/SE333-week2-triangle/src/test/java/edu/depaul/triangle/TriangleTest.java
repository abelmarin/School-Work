package edu.depaul.triangle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TriangleTest {
//	My Tests
	@Test
	@DisplayName("Assert Equals that passes")
	void testScalene() {
		String[] args = {"3", "4", "5"};
		Triangle t = new Triangle(args);
		TriangleType type = t.classify();
		assertEquals(TriangleType.SCALENE, type);
	}

	@Test
	@DisplayName("Should recognize Isosceles triangles")
	void testIsosceles() {
//		This should fail since the classify function doesn't have
//		a way of checking args[0] and args[2] against each other
//		in the case of isosceles triangles
		String[] args = {"3", "4", "3"};
		Triangle t = new Triangle(args);
		TriangleType type = t.classify();
		assertEquals(TriangleType.ISOSCELES, type);
	}

	@Test
	@DisplayName("Assert Throws that passes")
	void testNumberArgumentsError() {
		String[] args = {"1", "1"};
		assertThrows(IllegalArgumentException.class, () -> new Triangle(args));
	}

	@Test
	@DisplayName("Assert Throws that should pass but doesn't")
	void testNoNegativeNumbers() {
//		This should fail because validate args doesn't
//		check for negative side lengths
		String[] args = {"-1", "-1", "-1"};
		assertThrows(IllegalArgumentException.class, () -> new Triangle(args));
	}
}
