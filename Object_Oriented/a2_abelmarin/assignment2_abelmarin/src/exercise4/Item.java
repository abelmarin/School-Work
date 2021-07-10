// Abel Marin
// Exercise 4
package exercise4;

// This is the parent class of Book and Album
public class Item {
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String title;
    public double price;
    public String productID;

    public Item(String title, double price, String id) {
        this.title = title;
        this.price = price;
        this.productID = id;
    }
}
