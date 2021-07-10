package edu.depaul.se433.functional;

/**
 * A very sketchy version of DateObj from week 3.  Its
 * just here to support a demo of CSV based parameterized
 * tests.
 */
public class DateObj {

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  private int year;
  private int month;
  private int day;

  public DateObj(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  /**
   * Construct a DateObj from a string
   * @param data - string representation:  "year/month/day"
   * @return a new DateObj
   */
  public static DateObj makeDate(String data) {
    String[] parts = data.split("/");
    return new DateObj(
        Integer.valueOf(parts[0]),
        Integer.valueOf(parts[1]),
        Integer.valueOf(parts[2])
    );
  }

  public DateObj nextDate() {
    DateObj tomorrow = new DateObj(
        this.getYear(),
        this.getMonth(),
        this.getDay() + 1);
    return tomorrow;
  }

  @Override
  public boolean equals(Object other) {
    if (! (other instanceof DateObj)) {
      return false;
    }

    DateObj otherDate = (DateObj) other;
    return otherDate.getYear() == this.year
        && otherDate.getMonth() == this.month
        && otherDate.getDay() == this.day;
  }

  @Override
  public String toString() {
    return "DateObj(" + year + ", " + month + ", " + day + ")";
  }

}
