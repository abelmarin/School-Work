// Abel Marin
// Exercise 2
package exercise2;

public class BookTest {
    public static void main(String[] args) {

        Book book1 = new Book("Dune", 10.99, Genres.SCIFI);
        System.out.printf("Title = %s, Price = %.2f, Genre = %s%n", book1.getTitle(), book1.getPrice(), book1.getGenre());

        Book book2 = new Book("Steve Jobs", 15, Genres.BIOGRAPHY);
        System.out.printf("Title = %s, Price = %.2f, Genre = %s%n", book2.getTitle(), book2.getPrice(), book2.getGenre());

//        This doesn't work
//        Book book3 = new Book("Art Book", 16, Genres.ART);
//        System.out.printf("Title = %s, Price = %.2f, Genre = %s%n", book3.getTitle(), book3.getPrice(), book3.getGenre());
    }
}
