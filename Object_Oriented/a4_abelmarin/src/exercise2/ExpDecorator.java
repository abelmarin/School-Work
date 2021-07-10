// Exercise 2
// Abel Marin
package exercise2;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExpDecorator extends Decorator {

    public ExpDecorator(String text) {
        super(text);
    }

    public String formatText() {
        NumberFormat numFormat = new DecimalFormat("0.#####E0");
        Double valueNum = Double.valueOf(this.text);
        String textNum = numFormat.format(valueNum);
        return textNum;
    }
}
