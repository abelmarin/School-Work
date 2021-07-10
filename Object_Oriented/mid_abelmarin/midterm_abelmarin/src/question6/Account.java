// Abel Marin
// Question 6
package question6;

public class Account {
    private double balance = 0;
    private AccountHolder holder;

    public Account(AccountHolder holder) {
        this.holder = holder;
    }

    public void deposit(double amt) {
        this.balance += amt;
    }

    public void withdraw(double amt) {
        this.balance -= amt;
    }

    public double getBalance() {
        return balance;
    }
}
