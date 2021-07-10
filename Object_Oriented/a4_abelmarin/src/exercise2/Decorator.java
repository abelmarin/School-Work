// Exercise 2
// Abel Marin
package exercise2;

public abstract class Decorator {
    protected String text;
    public Decorator(String text) {
        this.text = text;
    }

    public abstract String formatText();
}
