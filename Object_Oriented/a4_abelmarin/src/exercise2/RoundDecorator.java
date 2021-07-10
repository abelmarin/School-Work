// Exercise 2
// Abel Marin
package exercise2;

public class RoundDecorator extends Decorator {

    public RoundDecorator(String text) {
        super(text);
    }

    public String formatText() {
        Double valueNum = Double.valueOf(this.text);
        String textNum = String.format("%.2f",valueNum);
        return textNum;
    }
}
