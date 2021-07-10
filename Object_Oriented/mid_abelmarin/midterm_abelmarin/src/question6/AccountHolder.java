// Abel Marin
// Question 6
package question6;

public class AccountHolder {
    protected int ID;
    public String address;
    Account [] accounts;

    public AccountHolder(int ID, String address) {
        this.ID = ID;
        this.address = address;
    }

    public static int nextID() {
        return 0;
    }
}
