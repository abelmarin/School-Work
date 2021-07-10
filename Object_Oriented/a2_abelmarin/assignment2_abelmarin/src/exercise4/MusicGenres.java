// Abel Marin
// Exercise 4
package exercise4;

public enum MusicGenres {
    ROCK("rock"),
    RAP("rap"),
    POP("pop"),
    COUNTRY("country"),
    CLASSICAL("classical");

    String strGenre;

    MusicGenres(String strMsg) {
        this.strGenre = strMsg;
    }

    public String getStrGenre() {
        return strGenre;
    }
}
