package Banksrus;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ingthor on 31.8.2016.
 * Savings Account for each Customer
 * This Account cannot be overdrawn and only has
 * a limited of transactions per month
 */
public class SavingsAccount extends Account
{
    private int transactionLimit;
    private int numberOfTransactionsThisMonth;
    private int whatMonthNow;
    private int oldMonth ;

    /**
     * Initializes the variables in the class
     * @param accountNumber
     * @param accountStatus
     * @param accountName
     * @param accountOwner
     * @param balance
     * @param transactionLimit Given number of transactions each month
     */
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
    /**
     * Overriden function inherited from Account
     * If the account is inactive the Customer can't
     * deposit any fee. If it is active the deposit is successful.
     * @param fee Integer value of the fee the Customer
     *            wants to withdraw from his balance
     */
    @Override
    void deposit(int fee) {
        if(accountStatus == false)
        {
            //Baeta error linur
            System.out.println("You cannot deposit into a closed account");
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
    /**
     * Overriden function inherited from Account
     * If the account is inactive the Customer cannot withdraw
     * The Customer can't withdraw more than the balance allows.
     * We check to see if the number of transaction exceed the limit
     * If it does the Customer gets an error message else we check if the
     * Month today isn't the same as the variable oldMonth. That means that
     * there is a new month and the number of transactions got to zero and
     * the Customer can withdraw. Else there is nothing wrong and the customer
     * can proceed to withdraw.
     * @param fee Integer value of the fee the Customer
     *            wants to withdraw from his balance
     */
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
        else if(numberOfTransactionsThisMonth >= transactionLimit)
        {
            System.out.println("You have reached the number of transactions for this month");
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
        else
        {
            balance -= fee;
            numberOfTransactionsThisMonth++;
        }
    }
}

