// Abel Marin
// Exercise 4
package exercise4;

enum BookGenres {
    NONFICTION("nonfiction"),
    NOVEL("novel"),
    SCIFI("scifi"),
    LITERATURE("literature"),
    THRILLER("thriller"),
    BIOGRAPHY("biography");

    String strGenre;

    BookGenres(String strMsg) {
        this.strGenre = strMsg;
    }

    public String getStrGenre() {
        return strGenre;
    }
}