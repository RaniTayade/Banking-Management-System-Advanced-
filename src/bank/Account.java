package bank;

public class Account {
    private int accNo;
    private String name;
    private double balance;

    public Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public int getAccNo() { return accNo; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    @Override
    public String toString() {
        return accNo + " - " + name + " - Balance: " + balance;
    }
}
