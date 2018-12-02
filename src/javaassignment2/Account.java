// Angel Naguit
// Ayusha Chaudhry 100968449

package javaassignment2;

public class Account {
    
    // State
    private final long accountNum;
    private double balance;
    private final String owner;

    // Constructor
    public Account(String owner, long accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.owner = owner;
    }

    // Getters
    public long getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
    
    // behaviour
    boolean withdraw(double amount){
        if(amount > balance || amount < 0)
            return false;
        balance -= amount;
        return true;
    }
    
    boolean deposit (double amount){
        if(amount < 0)
            return false;
        balance += amount;
        return true;
    }
    
    boolean transfer (Account a, double amount){
        if(this.withdraw(amount)){
            return (a.deposit(amount));   
        }
        return false;
    }

    @Override
    public String toString() {
        String s = accountNum + " - " + owner + " - " + balance + "\n" ;
        return s;
    }
    
    
}
