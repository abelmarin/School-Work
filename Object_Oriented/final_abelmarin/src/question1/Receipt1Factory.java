// Exercise 1
// Abel Marin
package question1;

public class Receipt1Factory implements ReceiptAbstractFactory {
    private Header header;
    private Footer footer;

    public Receipt1Factory() {
        this.header = new Header1();
        this.footer = new Footer1();
    }

    public String getMessage() {
        return header.getHeaderMessage() + "Receipt Body 1 " + footer.getHeaderMessage();
    }
}
