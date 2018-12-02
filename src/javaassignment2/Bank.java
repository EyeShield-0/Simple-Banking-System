// Angel Naguit
// Ayusha Chaudhry 100968449

package javaassignment2;

public class Bank {
    
    // State
    private final Account[] accountList;
    private int numAccounts;
    private final int maxAccount;

    // Constructor
    public Bank(int max) {
        this.numAccounts = 0;
        this.maxAccount = max;
        this.accountList = new Account[maxAccount];
    }
    
    // Behaviour
    public boolean addAccount(String own, long accNum,double bal){
        if((numAccounts >= maxAccount) || (bal < 0) || !(findAccount(accNum) == -1) || (accNum < 0))
            return false; 
        accountList[numAccounts] = new Account(own,accNum,bal);
        numAccounts++;
        return true;
    }
    
    private int findAccount(long accNum){
        for(int i = 0; i < numAccounts; i++){
            if(accountList[i].getAccountNum() == accNum)
                return i;
        }
        return -1;
    }
    
    public boolean depositAccount(long accNum, double amount){
        int index = findAccount(accNum);
        if(index == -1)
            return false;
        return (accountList[index].deposit(amount));
    }
    
    public boolean withdrawAccount(long accNum, double amount){
        int index = findAccount(accNum);
        if(index == -1)
            return false;
        return (accountList[index].withdraw(amount));
    } 
    
    public boolean transfer(long accNumFrom, long accNumTo, double amount){
        int iFrom = findAccount(accNumFrom);
        int iTo = findAccount(accNumTo);
        if((iFrom == -1) || (iTo == -1))
            return false;
        return (accountList[iFrom].transfer(accountList[iTo], amount));
    }
    
    public String printAccounts(){
        String s = "Account # - Owner - Balance" + "\n";
        for(int i = 0; i < numAccounts; i++){
            s += accountList[i].toString();
        }
        return s;
    }
}
