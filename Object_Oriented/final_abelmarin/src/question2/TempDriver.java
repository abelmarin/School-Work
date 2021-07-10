// Exercise 2
// Abel Marin
package question2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TempDriver {
    public static void main(String[] args) {
        TempInterface ts1 = new TS1();
        TempInterface ts2 = new TS1();
        TempInterface ts3 = new TS1();
        TempInterface ts4 = new Adapter();

        Date date = new Date();

        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String displayValue = timeFormatter.format(date);

        double temp1 = ts1.getTemp(date, displayValue);
        double temp2 = ts2.getTemp(date, displayValue);
        double temp3 = ts3.getTemp(date, displayValue);
        double temp4 = ts4.getTemp(date, displayValue);

        double averageTemp = (temp1+temp2+temp3+temp4)/4;

        System.out.println(averageTemp);
    }
}
