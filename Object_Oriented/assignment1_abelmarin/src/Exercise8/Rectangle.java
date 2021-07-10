// Abel Marin
// Exercise 8
package Exercise8;

public class Rectangle {
    public int width;
    public int length;
    static final int SIDES_NUMBER = 4;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int perimeter() {
        return (this.width*2)+(this.length*2);
    }

    public int area() {
        return this.width*this.length;
    }

    public String getDetails() {
        String returnStr = "".format("Width: %d, Length: %d, Perimeter = %d, Area = %d%n", this.width, this.length, this.perimeter(), this.area());
        return returnStr;
    }

    public void printDetails() {
        System.out.printf(this.getDetails());
    }
}
