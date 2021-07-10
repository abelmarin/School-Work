// Abel Marin
// Exercise 4
package exercise4;

public class Album extends Item {
    public String getGenre() {
        return genre.getStrGenre();
    }

    public void setGenre(MusicGenres genre) {
        this.genre = genre;
    }

    public String title;
    public MusicGenres genre;
    public double price;
    public String id;


    public Album(String title, double price, MusicGenres genre, String id) {
        super(title, price, id);
        this.genre = genre;
    }
}
