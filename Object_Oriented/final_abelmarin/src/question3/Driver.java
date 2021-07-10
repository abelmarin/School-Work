// Exercise 3
// Abel Marin
package question3;

public class Driver {
    public static void main(String[] args) {

        PizzaInterface pizza = new Pizza();
        ToppingDecorator olive = new Olive();
        ToppingDecorator pepper = new Pepper();
        ToppingDecorator mushroom = new Mushroom();

        String text = pizza.getItem() + pepper.getItem() + olive.getItem() + mushroom.getItem();

        System.out.println(text);
    }
}
