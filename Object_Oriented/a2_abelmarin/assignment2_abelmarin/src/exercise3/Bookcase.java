// Abel Marin
// Exercise 3
package exercise3;

import java.util.ArrayList;

public class Bookcase {
    public Genres genre;
    public ArrayList<Book> bookList = new ArrayList<Book>();

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public Genres getGenre() {
        return genre;
    }

    public Bookcase(Genres genre) {
        this.genre = genre;
    }

    public void addBook(Book book) {
        if (book.getGenre() == this.genre.getStrGenre()) {
            bookList.add(book);

        } else {
            System.out.println("Couldn't add book. Wrong genre.");
        }
    }
}
