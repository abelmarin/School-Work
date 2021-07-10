// Exercise 2
// Abel Marin
package exercise2;

public class AddUnitDecorator extends Decorator {
    protected String units;

    public AddUnitDecorator(String text, String units) {
        super(text);
        this.units = units;
    }

    public String formatText() {
        String textNum = this.text + " " + units;
        return textNum;
    }
}
