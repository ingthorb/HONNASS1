package Banksrus;

import java.util.Date;

/**
 * Created by Ingthor on 31.8.2016.
 */
public class SavingsAccount extends Account
{
    private int overdrawnFigure;
    //Else error message
    private int transactionLimit;
    private int numberOfTransactionsPerMonth;
//    private Date whatMonth;

    public SavingsAccount(int accountNumber, boolean accountStatus, String accountName, String accountOwner, int balance,int overdrawnFigure,int transactionLimit) {

        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.accountName = accountName;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.overdrawnFigure = overdrawnFigure;
        this.transactionLimit = transactionLimit;
        this.numberOfTransactionsPerMonth = 0;
       // this.whatMonth = new Date();
    }

    @Override
    void deposit(int fee) {
        balance += fee;
    }

    @Override
    void withdraw(int fee) {

        if(fee > overdrawnFigure)
        {
            System.out.println("You cannot withdraw this");
        }
        else
        {
            if(numberOfTransactionsPerMonth < transactionLimit)
            {
                balance -= fee;
            }
        }

    }
}
