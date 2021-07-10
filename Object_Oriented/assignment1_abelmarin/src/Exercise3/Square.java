// Abel Marin
// Exercise 3
package Exercise3;

public class Square {
    public int side;

    public Square(int side) {
        this.side = side;
    }

    public int perimeter() {
        return this.side*4;
    }

    public int area() {
        return this.side * this.side;
    }
}
