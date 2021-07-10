// Abel Marin
// Exercise 2
package exercise2;

public class Book {

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre.getStrGenre();
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String title;
    public Genres genre;
    public double price;

    public Book(String title, double price, Genres genre) {
        this.title = title;
        this.price = price;
        this.genre = genre;
    }
}
