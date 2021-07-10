// Abel Marin
// Exercise 3
package exercise3;

public class SingletonTest {
    public static void main(String args[]) {
        SingletonAssignment3 test = new SingletonAssignment3();

        test.getInstance("No");
        test.getInstance("Yes");
        test.getInstance("Yes");
        test.getInstance("Yes");
        test.getInstance("Yes");

    }
}
