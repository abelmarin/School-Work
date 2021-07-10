package edu.depaul.se433.functional;

import static edu.depaul.se433.functional.DateObj.makeDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class DateObjCsvTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/dates.csv", numLinesToSkip = 1)
  void compareDates(String todayString, String expectedString) {
    DateObj today = makeDate(todayString);
    DateObj expected = makeDate(expectedString);
    assertEquals(expected, today.nextDate());
  }
}
