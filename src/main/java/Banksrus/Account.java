package Banksrus;

/**
 * Created by Ingthor on 31.8.2016.
 * Abstract class Account for all accounts for all
 * customers. Is a Layer Supertype
 */
public abstract class Account {

    protected int accountNumber;
    protected boolean accountStatus;
    protected String accountName;
    protected String accountOwner;
    protected int balance;

    abstract void deposit(int fee);
    abstract void withdraw(int fee);

}
