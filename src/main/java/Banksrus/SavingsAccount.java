package Banksrus;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ingthor on 31.8.2016.
 */
public class SavingsAccount extends Account
{
    private int transactionLimit;
    private int numberOfTransactionsThisMonth;
    private int whatMonthNow;
    private int oldMonth ;

    public SavingsAccount(int accountNumber, boolean accountStatus, String accountName, String accountOwner, int balance,int transactionLimit) {

        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.accountName = accountName;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.transactionLimit = transactionLimit;
        this.numberOfTransactionsThisMonth = 0;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //Indexed from 0
        this.whatMonthNow = cal.get(Calendar.MONTH);
        this.oldMonth = 8;
    }

    @Override
    void deposit(int fee) {
        if(accountStatus == false)
        {
            //Depositing into an inactive account makes it active
            balance += fee;
            accountStatus = true;
        }
        else if(fee < 0)
        {
            System.out.println("You cannot deposit a negative amount");
        }
        else
        {
            balance += fee;
        }
    }

    @Override
    void withdraw(int fee) {
        if(accountStatus == false)
        {
            System.out.println("You cannot withdraw from an inactive account");
        }
        else if(balance < fee)
        {
            System.out.println("You cannot withdraw this amount as it exceeds the balance");
        }
        //If the month now has changed
        else if(whatMonthNow != oldMonth)
        {
            //Set the variable oldMonth to the newMonth variable to stay current
            oldMonth = whatMonthNow;
            numberOfTransactionsThisMonth = 0;
            balance -= fee;
            numberOfTransactionsThisMonth++;
        }
        else if(numberOfTransactionsThisMonth >= transactionLimit)
        {
            System.out.println("You have reached the number of transactions for this month");
        }
        else
        {
            balance -= fee;
            numberOfTransactionsThisMonth++;
        }
    }
}

