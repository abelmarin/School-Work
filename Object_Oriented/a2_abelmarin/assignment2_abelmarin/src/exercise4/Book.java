// Abel Marin
// Exercise 4
package exercise4;

public class Book extends Item {

    public String getGenre() {
        return genre.getStrGenre();
    }

    public void setGenre(BookGenres genre) {
        this.genre = genre;
    }

    public String title;
    public BookGenres genre;
    public double price;
    public String id;

    public Book(String title, double price, BookGenres genre, String id) {
        super(title,price,id);
        this.id = id;
    }
}
