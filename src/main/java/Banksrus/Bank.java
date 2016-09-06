package Banksrus;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ingthor on 5.9.2016.
 * Bank holds all customers and Accounts.
 * Making it easy to add a customer and accounts.
 */
public class Bank {

    private ArrayList<Account> Accounts = new ArrayList<Account>();
    private ArrayList<Customer> Customers = new ArrayList<Customer>();

    public Bank() {

    }

    /**
     * Adds a account to the arraylist
     * @param accounts gets the Account that is added to the bank
     */
    public void addAccounts(Account accounts)
    {
        Accounts.add(accounts);
    }

    /**
     * Adds a Customer to the arraylist
     * @param customer gets the Customer that is added to the bank
     */
    public void addCustomers(Customer customer)
    {
        Customers.add(customer);
    }

    /**
     * Function that prints out all Accounts of all customers
     * Prints out the name, owner, number, status and balance of each Account
     */
    public void printAllAccountsForCostumers()
    {

      System.out.println("All accounts:");
      for(int i = 0; i < Accounts.size(); i++)
      {
          System.out.println("Account Name: " + Accounts.get(i).accountName);
          System.out.println("Account Owner: " + Accounts.get(i).accountOwner);
          System.out.println("Account Number: " + Accounts.get(i).accountNumber);
          System.out.println("Account Status: " + Accounts.get(i).accountStatus);
          System.out.println("Account balance: " + Accounts.get(i).balance);
          System.out.println("");
      }

    }
    /**
     * Function that prints out all active Accounts of the specific Customer
     * Prints out the name, owner, number, status and balance of each active Account
     */
    public void printActiveAccountsForCostumer(Customer customer)
    {
        System.out.println("All active accounts:");
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
}
