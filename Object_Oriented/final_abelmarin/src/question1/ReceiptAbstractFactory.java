// Exercise 1
// Abel Marin
package question1;

public interface ReceiptAbstractFactory {
    Header header = null;
    Footer footer = null;

    String getMessage();
}
