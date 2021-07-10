// Exercise 2
// Abel Marin
package question2;

import java.util.Date;

public class TS1 implements TempInterface {

    public double getTemp(Date date, String t) {
        return Math.random()*100;
    }

}
