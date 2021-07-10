// Abel Marin
// Exercise 3
package exercise3;

enum Genres {
    NONFICTION("nonfiction"),
    NOVEL("novel"),
    SCIFI("scifi"),
    LITERATURE("literature"),
    THRILLER("thriller"),
    BIOGRAPHY("biography");

    String strGenre;

    Genres(String strMsg) {
        this.strGenre = strMsg;
    }

    public String getStrGenre() {
        return strGenre;
    }
}