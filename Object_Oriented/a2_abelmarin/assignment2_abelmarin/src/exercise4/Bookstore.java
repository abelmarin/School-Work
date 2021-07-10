// Abel Marin
// Exercise 4
package exercise4;

import java.util.ArrayList;

public class Bookstore {
    public String storeName;
    public ArrayList<Bookcase> bookcaseList = new ArrayList<Bookcase>();

    public ArrayList<Bookcase> getBookcaseList() {
        return bookcaseList;
    }

    public String getStoreName() {
        return storeName;
    }

    public Bookstore(String storeName) {
        this.storeName = storeName;
    }

    public void addBookcase(Bookcase bookcase) {
        if (!testGenre(bookcase)) {
            bookcaseList.add(bookcase);
        } else {
            System.out.println("Genre of bookcase already added.");
        }
    }

    private boolean testGenre(Bookcase bookcase) {
        for (int i = 0; i < bookcaseList.size(); i++) {
            if (bookcaseList.get(i).getGenre() == bookcase.getGenre()) {
                return true;
            }
        }
        return false;
    }
}
