// Exercise 3
// Abel Marin
package question2;

public class TS4 {
    public double getTS4Temp(String year, String month, String day, String time, String when) {
        double returnNum = convertTemp((Math.random()*100)*10);
        return returnNum;
    }

    private double convertTemp(double num) {
        num = (num - 32) *5/9;
        return num;
    }
}
