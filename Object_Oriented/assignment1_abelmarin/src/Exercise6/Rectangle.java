// Abel Marin
// Exercise 6
package Exercise6;

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
}