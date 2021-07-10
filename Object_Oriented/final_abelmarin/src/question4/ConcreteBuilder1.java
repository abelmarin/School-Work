// Exercise 4
// Abel Marin
package question4;

public class ConcreteBuilder1 implements Builder {
    Product product = new Product();

    public void setPart1() {
        product.Part1 = 11;
    }

    public void setPart2() {
        product.Part2 = 12;
    }

    public void setPart3() {
        product.Part3 = 13;
    }

    public void setPart4() {
        product.Part4 = 14;
    }

    public Product getProduct() {
        return product;
    }

}
