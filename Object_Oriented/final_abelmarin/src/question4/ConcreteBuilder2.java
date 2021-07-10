// Exercise 4
// Abel Marin
package question4;

public class ConcreteBuilder2 implements Builder {
    Product product = new Product();

    public void setPart1() {
        product.Part1 = 21;
    }

    public void setPart2() {
        product.Part2 = 22;
    }

    public void setPart3() {
        product.Part3 = 23;
    }

    public void setPart4() {
        product.Part4 = 24;
    }

    public Product getProduct() {
        return product;
    }
}
