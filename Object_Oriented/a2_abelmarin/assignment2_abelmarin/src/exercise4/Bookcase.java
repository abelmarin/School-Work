// Abel Marin
// Exercise 4
package exercise4;

import java.util.ArrayList;

public class Bookcase {
    public BookGenres genre;
    public ArrayList<Book> bookList = new ArrayList<Book>();

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public BookGenres getGenre() {
        return genre;
    }

    public Bookcase(BookGenres genre) {
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
