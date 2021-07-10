// Abel Marin
// Exercise 8
package Exercise8;

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
        return this.side*this.side;
    }

    public String getDetails() {
        String returnStr = "".format("Side length: %d, Perimeter = %d, Area = %d%n", this.side, this.perimeter(), this.area());
        return returnStr;
    }

    public void printDetails() {
        System.out.printf(this.getDetails());
    }
}
