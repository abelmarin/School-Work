// Abel Marin
// Question 6
package question6;

public class IndividualHolder extends AccountHolder {
    private String name;
    private String SSN;

    public IndividualHolder(int ID, String address, String name, String SSN) {
        super(ID, address);
        this.name = name;
        this.SSN = SSN;
    }
}
