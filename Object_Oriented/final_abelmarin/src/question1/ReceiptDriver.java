// Exercise 1
// Abel Marin
package question1;

public class ReceiptDriver {

    public static void main(String[] args) {
        ReceiptAbstractFactory receipt = new Receipt1Factory();

        System.out.println(receipt.getMessage());
    }
}
