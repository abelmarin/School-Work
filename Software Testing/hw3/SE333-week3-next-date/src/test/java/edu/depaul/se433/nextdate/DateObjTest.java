/*
 * Assignment: #3
 * Topic: Boundary tests
 * Author: <Abel-Marin>
 */

package edu.depaul.se433.nextdate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateObjTest {

	// Test for the DateObj constructor
	@Test
	@DisplayName("Constructor should throw an exception on bad Feb 29")
	void testConstructorBadFeb() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(2019, 2, 29));
	}

	@Test
	@DisplayName("Should throw an exception when year is divisible by 4 and 100 but not 400")
	void testConstructorGoodFeb() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(1900, 2, 29));
	}

	@Test
	@DisplayName("Should throw an exception when day is greater than 30")
	void testConstructor30Months() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(2020, 9, 31));
	}

	@Test
	@DisplayName("Should throw an exception when day is greater than 31")
	void testConstructor31Months() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(2020, 1, 32));
	}

	@Test
	@DisplayName("Should throw an exception when day is less than 1")
	void testConstructorDayOver1() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(2020, 9, 0));
	}

	@Test
	@DisplayName("Should throw an exception when year is less than 0")
	void testConstructorYearOver0() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(-1, 9, 2));
	}

	@Test
	@DisplayName("Should throw an exception when month is less than 1")
	void testConstructorMonthOver1() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(2020, 0, 3));
	}

	@Test
	@DisplayName("Should throw an exception when month is greater than 12")
	void testConstructorMonthUnder13() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(2020, 15, 4));
	}

	// Tests for nextDate function
	@Test
	@DisplayName("Should return March 1st after leap day")
	void testLeapDay() {
		DateObj leapDay = new DateObj(2020, 2, 29);
		DateObj marchFirst = new DateObj(2020, 3, 1);
		assertEquals(marchFirst, leapDay.nextDate());
	}

	@Test
	@DisplayName("Should return Feb 29th")
	void testFeb28LeapYear() {
		DateObj feb28 = new DateObj(2020, 2, 28);
		DateObj feb29 = new DateObj(2020, 2, 29);
		assertEquals(feb29, feb28.nextDate());
	}

	@Test
	@DisplayName("Should return March 1st")
	void testFeb28RegularYear() {
		DateObj feb28 = new DateObj(2019, 2, 28);
		DateObj marchFirst = new DateObj(2019, 3, 1);
		assertEquals(marchFirst, feb28.nextDate());
	}

	@Test
	@DisplayName("Should return next day in February")
	void testFebBeginMonth() {
		DateObj feb1 = new DateObj(2019, 2, 1);
		DateObj feb2 = new DateObj(2019, 2, 2);
		assertEquals(feb2, feb1.nextDate());
	}

	@Test
	@DisplayName("Should return next day in February")
	void testFebMidMonth() {
		DateObj feb14 = new DateObj(2019, 2, 14);
		DateObj feb15 = new DateObj(2019, 2, 15);
		assertEquals(feb15, feb14.nextDate());
	}


	@Test
	@DisplayName("Should return January 1st of the next year")
	void testChangeYear() {
		DateObj lastDayOfYear = new DateObj(2020, 12, 31);
		DateObj janFirst = new DateObj(2021, 1, 1);
		assertEquals(janFirst, lastDayOfYear.nextDate());
	}

	@Test
	@DisplayName("Should return next day from same month")
	void test31BeginMonth() {
		DateObj march1 = new DateObj(2020, 3, 1);
		DateObj march2 = new DateObj(2020, 3, 2);
		assertEquals(march2, march1.nextDate());
	}

	@Test
	@DisplayName("Should return next day from same month")
	void test31MidMonth() {
		DateObj march14 = new DateObj(2020, 3, 14);
		DateObj march15 = new DateObj(2020, 3, 15);
		assertEquals(march15, march14.nextDate());
	}

	@Test
	@DisplayName("Should return next day from next month")
	void test31EndOfMonth() {
		DateObj march31 = new DateObj(2020, 3, 31);
		DateObj april1 = new DateObj(2020, 4, 1);
		assertEquals(april1, march31.nextDate());
	}


	@Test
	@DisplayName("Should return next day from same month")
	void test30BeginMonth() {
		DateObj sep1 = new DateObj(2020, 9, 1);
		DateObj sep2 = new DateObj(2020, 9, 2);
		assertEquals(sep2, sep1.nextDate());
	}

	@Test
	@DisplayName("Should return next day from same month")
	void test30MidMonth() {
		DateObj sep14 = new DateObj(2020, 9, 14);
		DateObj sep15 = new DateObj(2020, 9, 15);
		assertEquals(sep15, sep14.nextDate());
	}

	@Test
	@DisplayName("Should return next day from next month")
	void test30EndOfMonth() {
		DateObj sep30 = new DateObj(2020, 9, 30);
		DateObj oct1 = new DateObj(2020, 10, 1);
		assertEquals(oct1, sep30.nextDate());
	}

}
