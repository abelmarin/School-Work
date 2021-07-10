// Abel Marin
// Exercise 3
package exercise3;

import java.util.ArrayList;

public class BookstoreTest {
    public static void main(String[] args) {
        Bookcase bookcase1 = new Bookcase(Genres.BIOGRAPHY);

        Book book1 = new Book("Dune", 10.99, Genres.SCIFI);
        Book book2 = new Book("Steve Jobs", 15, Genres.BIOGRAPHY);

        bookcase1.addBook(book1);
        bookcase1.addBook(book2);

        // Checks to see if the correct books were added to bookcase 1
        ArrayList<Book> testBooks = bookcase1.getBookList();
        for (int i = 0; i < testBooks.size(); i++) {
            System.out.println(testBooks.get(i).getGenre());
        }

        Bookcase bookcase2 = new Bookcase(Genres.SCIFI);
        Bookcase bookcase3 = new Bookcase(Genres.SCIFI);

        Bookstore bookstore = new Bookstore("Abe's Bookstore");

        bookstore.addBookcase(bookcase1);
        bookstore.addBookcase(bookcase2);
        bookstore.addBookcase(bookcase3);

        // Checks to see if the correct bookcases were added to the bookstore
        ArrayList<Bookcase> testBookcases = bookstore.getBookcaseList();
        for (int i = 0; i < testBookcases.size(); i++) {
            System.out.println(testBookcases.get(i).getGenre());
        }

    }
}
