// Exercise 4
// Abel Marin
package question4;

public class Driver {
    public static void main(String[] args) {
        // ConcreteBuilder1 test
        Builder builder1 = new ConcreteBuilder1();
        builder1.setPart1();
        builder1.setPart2();
        builder1.setPart3();
        builder1.setPart4();
        Product product1 = builder1.getProduct();
        System.out.println(product1.getParts());

        // ConcreteBuilder1 test
        Builder builder2 = new ConcreteBuilder2();
        builder2.setPart1();
        builder2.setPart2();
        builder2.setPart3();
        builder2.setPart4();
        Product product2 = builder2.getProduct();
        System.out.println(product2.getParts());

        // ConcreteBuilder1 test
        Builder builder3 = new ConcreteBuilder3();
        builder3.setPart1();
        builder3.setPart2();
        builder3.setPart3();
        builder3.setPart4();
        Product product3 = builder3.getProduct();
        System.out.println(product3.getParts());

    }
}