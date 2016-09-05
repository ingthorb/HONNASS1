package Banksrus;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ingthor on 5.9.2016.
 *
 */
public class Bank {

    private ArrayList<Account> Accounts = new ArrayList<Account>();
    private ArrayList<Customer> Customers = new ArrayList<Customer>();

    public Bank() {

    }

    public void addAccounts(Account accounts)
    {
        Accounts.add(accounts);
    }

    public void addCustomers(Customer customer)
    {
        Customers.add(customer);
    }

    public void printAllAccountsForCostumers()
    {
        //Breyta í streng
      String allAccounts = "";
     allAccounts += "All accounts"  ;
      for(int i = 0; i < Accounts.size(); i++)
      {
          allAccounts += ("Account Name: " + Accounts.get(i).accountName);
          System.out.println("Account Owner: " + Accounts.get(i).accountOwner);
          System.out.println("Account Number: " + Accounts.get(i).accountNumber);
          System.out.println("Account Status: " + Accounts.get(i).accountStatus);
          System.out.println("Account balance: " + Accounts.get(i).balance);
          System.out.println("");
      }
    }

    public void printActiveAccountsForCostumer(Customer customer)
    {
        System.out.println("All active accounts");
        for(int i = 0; i < Accounts.size(); i++)
        {
            if(Accounts.get(i).accountStatus == true && Accounts.get(i).accountOwner == customer.getCustomerName())
            {
                System.out.println("Account Name: " + Accounts.get(i).accountName);
                System.out.println("Account Owner: " + Accounts.get(i).accountOwner);
                System.out.println("Account Number: " + Accounts.get(i).accountNumber);
                System.out.println("Account Status: " + Accounts.get(i).accountStatus);
                System.out.println("Account balance: " + Accounts.get(i).balance);
                System.out.println("");
            }
        }
    }

    //Holds all accounts and customers in ArrayList
}
