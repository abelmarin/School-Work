package edu.depaul.se433.functional;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class PositionFinderTest {

	/**
	 * a = null
	 */
	@Test(expected = IllegalArgumentException.class) 
	public void null_should_throw_exception() {
		PositionFinder.findPosition(null, 5);
	}
	
	/**
	 * a = {}
	 */
	@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void test_invalid_array() {
		int[] a = new int[] {};
		PositionFinder.findPosition(a, 5);
	}
	
	/**
	 * a = {2}
	 */
	@Ignore
	@Test
	public void test_not_there_array() {
		int[] a = new int[] {2};
		PositionFinder.findPosition(a, 5);
	}	
	
	/**
	 * a = {5}
	 */
	@Test
	public void test_is_there_array() {
		int[] a = new int[] {5};
		PositionFinder.findPosition(a, 5);
	}
		

	
	/**
	 * a = {2,5}
	 */
	@Ignore
	@Test
	public void test_together_array() {
		int[] a = new int[] {2,5};
		PositionFinder.findPosition(a, 5);
	}	
	
	@Test
	public void constructor_works() {
		new PositionFinder();
	}
}
