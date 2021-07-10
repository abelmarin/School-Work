// Abel Marin
// Exercise 6
package Exercise6;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(5, 10);
        Rectangle rect2 = new Rectangle(7, 14);

        System.out.printf("Perimeter = %d, Area = %d%n", rect1.perimeter(), rect1.area());
        System.out.printf("Perimeter = %d, Area = %d%n", rect2.perimeter(), rect2.area());
    }
}
