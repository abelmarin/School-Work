// Exercise 4
// Abel Marin
package question4;

public class ConcreteBuilder3 implements Builder {
    Product product = new Product();

    public void setPart1() {
        product.Part1 = 31;
    }

    public void setPart2() {
        product.Part2 = 32;
    }

    public void setPart3() {
        product.Part3 = 33;
    }

    public void setPart4() {
        product.Part4 = 34;
    }

    public Product getProduct() {
        return product;
    }
}
