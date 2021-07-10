// Abel Marin
// Exercise 2
 package Exercise2;

public class SquareTest {
    public static void main(String[] args) {
        Square sqr = new Square();
        sqr.side = 5;

        System.out.printf("Perimeter = %d, Area = %d%n", sqr.perimeter(), sqr.area());
    }
}
