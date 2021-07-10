// Abel Marin
// Exercise 7
package Exercise7;

public class Rectangle {
    public int width;
    public int length;
    static final int SIDES_NUMBER = 4;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int perimeter() {
        return (this.width * 2) + (this.length * 2);
    }

    public int area() {
        return this.width * this.length;
    }

    public void printDetails() {
        System.out.printf("Width: %d, Length: %d, Perimeter = %d, Area = %d%n", this.width, this.length, this.perimeter(), this.area());
    }
}