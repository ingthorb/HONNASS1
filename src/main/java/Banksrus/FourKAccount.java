package Banksrus;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ingthor on 31.8.2016.
 * The savings account of a Customer
 * Can only withdraw if he is over 65
 */
public class FourKAccount extends Account
{
    private int withdrawalAge;
    private Customer customer;
    private int whatYearNow;

    /**
     * Initializes the variables in the class
     * @param accountNumber
     * @param accountStatus
     * @param accountName
     * @param accountOwner
     * @param balance
     * @param customer
     */
    public FourKAccount(int accountNumber, boolean accountStatus, String accountName, String accountOwner, int balance,Customer customer) {
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.accountName = accountName;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.withdrawalAge = 65;
        this.customer = customer;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        /**
         * Get the Year from the Calendar instance
         */
        this.whatYearNow = cal.get(Calendar.YEAR);
    }

    /**
     * Gets the Customers age from the variable DateOfBirth
     * in the Customer class. Extracts the final 4 digits in the string
     * and converts them to Integer and returns the year the customer was born
     * @return age The year the customer was born
     */
    public int getCustomersAge()
    {
        String customerAge = customer.getCustomerDateOfBirth();
        String st2 = customerAge.substring(6, customerAge.length() - 0);
        int age = Integer.parseInt(st2);
        return age;

    }

    /**
     * Overriden function inherited from Account
     * The Customer has to be over 65 to withdraw.
     * Here we calculate the age of the Customer and
     * check to see if he is old enough to withdraw.
     * If the account is inactive the Customer cannot withdraw
     * @param fee Integer value of the fee the Customer
     *            wants to withdraw from his balance
     */
    @Override
    void withdraw(int fee) {
        int customersDateOfBirth = getCustomersAge();
        int customersAge = whatYearNow - customersDateOfBirth;
        if(accountStatus == false)
        {
            System.out.println("You cannot withdraw from an inactive account");
        }
        if(customersAge > withdrawalAge)
        {
            balance -= fee;
        }
        else
        {
            System.out.println("You are not old enough to withdraw");
        }
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
            System.out.println("You cannot deposit into a closed account");
        }
        if(fee < 0)
        {
            System.out.println("You cannot deposit a negative amount");
        }
        else
        {
            balance += fee;
        }

    }
}
