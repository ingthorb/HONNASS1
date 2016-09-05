package Banksrus;

/**
 * Created by Ingthor on 31.8.2016.
 */
public class FourKAccount extends Account
{
    private int withdrawalAge;
    public FourKAccount(int accountNumber, boolean accountStatus, String accountName, String accountOwner, int balance,int withdrawalAge) {
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.accountName = accountName;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.withdrawalAge = withdrawalAge;
    }

    @Override
    void withdraw(int fee) {
    }

    @Override
    void deposit(int fee) {
        balance += fee;
    }
}
