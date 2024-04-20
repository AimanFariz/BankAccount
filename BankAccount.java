public class BankAccount {
    private long acctNo;
    private String name;
    private String address;
    private int taxID;
    private double balance;

    public BankAccount(long acctNo, String name, String address, int taxID, double balance) {
        this.acctNo = acctNo;
        this.name = name;
        this.address = address;
        this.taxID = taxID;
        this.balance = balance;
    }

    public BankAccount(BankAccount otherAccount) {
        this.acctNo = otherAccount.acctNo;
        this.name = otherAccount.name;
        this.address = otherAccount.address;
        this.taxID = otherAccount.taxID;
        this.balance = otherAccount.balance;
    }

    // getters
    public long getAccount_no() {
        return acctNo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getTaxID() {
        return taxID;
    }

    public double getBalance() {
        return balance;
    }

    // setters
    public void setAccount_no(long acctNo) {
        this.acctNo = acctNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // methods
    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            receiver.deposit(amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // public String toString() {
    // return String.format("Account Number: %d\nName: %s\nAddress: %s\nBalance:
    // $%.2f",
    // acctNo, name, address, balance);
    // }
    public String toString() {
        String str = String.format("Account Number : %d\nName : %s\nAddress : %s\nTaxID : %d\nBalance : $%.2f\n",
                getAccount_no(), getName(),
                getAddress(), getTaxID(), getBalance());
        return str;
    }

}
