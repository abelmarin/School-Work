// Abel Marin
// Exercise 6
package Exercise6;

public class Square {
    public int side;
    static final int SIDES_NUMBER = 4;

    public Square(int side) {
        this.side = side;
    }

    public int perimeter() {
        return this.side*SIDES_NUMBER;
    }

    public int area() {
        return this.side * this.side;
    }
}
