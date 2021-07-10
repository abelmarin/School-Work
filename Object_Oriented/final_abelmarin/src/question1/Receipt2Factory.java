// Exercise 1
// Abel Marin
package question1;

public class Receipt2Factory implements ReceiptAbstractFactory {
    private Header header;
    private Footer footer;

    public Receipt2Factory() {
        this.header = new Header2();
        this.footer = new Footer2();
    }

    public String getMessage() {
        return header.getHeaderMessage() + "Receipt Body 2 " + footer.getHeaderMessage();
    }
}
