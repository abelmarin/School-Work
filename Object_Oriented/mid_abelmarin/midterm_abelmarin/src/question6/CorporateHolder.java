// Abel Marin
// Question 6
package question6;

public class CorporateHolder extends AccountHolder {
    private String contact;

    public CorporateHolder(int ID, String address, String contact) {
        super(ID, address);
        this.contact = contact;
    }
}
