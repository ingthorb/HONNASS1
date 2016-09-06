package Banksrus;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ingthor on 31.8.2016.
 */
public class FourKAccount extends Account
{
    private int withdrawalAge;
    private Customer customer;
    private int whatYearNow;

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
        this.whatYearNow = cal.get(Calendar.YEAR);
    }
    public int getCustomersAge()
    {
        String customerAge = customer.getCustomerDateOfBirth();
        String st2 = customerAge.substring(6, customerAge.length() - 0);
        int age = Integer.parseInt(st2);
        return age;

    }
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
            //System.out.println("We go in withdraw in age");
            balance -= fee;
        }
        else
        {
            System.out.println("You are not old enough to withdraw");
        }
    }

    @Override
    void deposit(int fee) {
        if(accountStatus == false)
        {
            //Depositing into an inactive account makes it active
            balance += fee;
            accountStatus = true;
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
