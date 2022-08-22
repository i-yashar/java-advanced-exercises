package DefiningClasses;

public class BankAccount {
    private static int accountsCount = 1;
    private int ID;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount(){
        this.ID = accountsCount++;
    }

    public int getID(){
        return this.ID;
    }

    public static void setInterestRate(double interest){
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years){
        return this.balance * years * interestRate;
    }

    public void deposit(double amount){
        this.balance += amount;
    }


}
