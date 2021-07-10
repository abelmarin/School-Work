/*
 * Assignment: #3
 * Topic: Boundary tests
 * Author: <Abel-Marin>
 */

package edu.depaul.se433.nextdate;

/**
 * Implements a next date function for the sake of learning
 * unit test strategies.
 */
public class DateObj {
  
  private int year;
  private int month;
  private int day;
  private int[] monthLengths = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  
  public DateObj(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
    validate();
  }

  /**
   * Calculates the next date after the one represented by this
   * and returns it.
   * @return a DateObj of next date
   */
  public DateObj nextDate() {
    // TODO: return the next valid date after this one
    DateObj nextDate = new DateObj(this.year, this.month, this.day);

    // Case 1: Months of length 30
    if (monthLengths[this.month-1] == 30) {
      // Handles case where next day is in next month
      if (this.day == 30) {
        nextDate.month++;
        nextDate.day = 1;
      }
      // Handles a next day that is within the current month
      else
        nextDate.day++;
    }

    // Case 2: Months of length 31
    else if (monthLengths[this.month-1] == 31) {
      // Handles case where month is not Dec and next day is in next month
      if (this.day == 31 && this.month != 12) {
        nextDate.month++;
        nextDate.day = 1;
      }
      // Handles case where month is Dec and next day is Jan 1st
      else if (this.day == 31 && this.month == 12) {
        nextDate.year++;
        nextDate.month = 1;
        nextDate.day = 1;
      }
      // Handles a next day that is within the current month
      else
        nextDate.day++;
    }

    // Case 3: February
    else if (monthLengths[this.month-1] == 28) {
      // Handles Feb 29 nextDate
      if (this.day == 29 && ((year % 4 == 0 && year % 100 != 0) || this.year % 400 == 0)) {
        nextDate.day = 1;
        nextDate.month = 3;
      }
      // Handles Feb 28 next date during a leap year
      else if (this.day == 28 && ((year % 4 == 0 && year % 100 != 0) || this.year % 400 == 0)) {
        nextDate.day++;
      }
      // Handles Feb 28 next date during a regular year
      else if (this.day == 28) {
        nextDate.day = 1;
        nextDate.month = 3;
      }
      // Handles a next day that is within the current month
      else
        nextDate.day++;
    }

    return nextDate;
  }

  @Override
  /**
   * Return a string representation of the the DateObj.  This is
   * for debugging purposes only.  Do not use it to compare dates
   * in tests.
   */
  public String toString() {
    return String.format("Date[year: %d, month: %d, day: %d]", year, month, day);
  }

  @Override
  /**
   * The various assert functions need a relevant equals() function to be
   * effective.  Supply it here
   */
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof DateObj)) return false;

    DateObj otherDate = (DateObj)other;
    if (this.year == otherDate.year && this.month == otherDate.month && this.day == otherDate.day)
      return true;
    return false;
  }

  private void validate() {
    // TODO: throw an IllegalArgumentException if the current values of year,
    //  month and day do not make a valid date
    // Checks whether a February date is valid
    if (month == 2 && day > 29) {
      throw new IllegalArgumentException("Not a valid date");
    } else if (day == 29 && ((year % 4 != 0) || (year % 100 == 0 && year % 400 != 0)) && month == 2) {
      throw new IllegalArgumentException("Not a valid date");
    }

    // Checks whether a January, March, May, July, August, October or December
    // date is valid
    else if ((this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7
            || this.month == 8 || this.month == 10 || this.month == 12) && this.day > 31) {
      throw new IllegalArgumentException("Not a valid date");
    }

    // Checks whether a April, June, September or November date is valid
    else if ((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) && this.day > 30) {
      throw new IllegalArgumentException("Not a valid date");
    }

    // Checks whether a day is less than 1
    if (this.day < 1) {
      throw new IllegalArgumentException("Not a valid date");
    }

    // Checks whether a month is valid
    if ((this.month < 1) || (this.month > 12)) {
      throw new IllegalArgumentException("Not a valid date");
    }

    // Checks whether a year is valid
    if (this.year < 0) {
      throw new IllegalArgumentException("Not a valid date");
    }

    // Checks whether a month, day, or year is an integer
    if ((this.day != (int)this.day) || (this.month != (int)this.month) || (this.year != (int)this.year)) {
      throw new IllegalArgumentException("Not a valid date");
    }
  }
}























