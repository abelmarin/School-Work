// Exercise 2
// Abel Marin
package question2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Adapter implements TempInterface {

    public double getTemp(Date date, String t) {
        TS4 sensor4 = new TS4();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("PST"));
        cal.setTime(date);
        String year = String.valueOf(cal.get(Calendar.YEAR));
        String month = String.valueOf(cal.get(Calendar.MONTH));
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));

        SimpleDateFormat timeFormatter = new SimpleDateFormat("h");
        String displayValue = timeFormatter.format(date);
        int intValue = Integer.parseInt(displayValue);

        String time = "";
        String when = "";

        if (intValue > 12) {
            intValue -= 12;
            time = String.valueOf(intValue);
            when = "PM";
        } else if (intValue == 0) {
            time = "12";
            when = "AM";
        } else {
            time = String.valueOf(intValue);
            when = "AM";
        }

        return sensor4.getTS4Temp(year, month, day, time, when);
    }
}
