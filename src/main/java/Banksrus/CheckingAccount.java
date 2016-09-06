package Banksrus;

/**
 * Created by Ingthor on 31.8.2016.
 * Checking Account for Customers
 * Can be owerdrawn by a specific amount
 * Has a specific free withdraw transactions
 *
 */
public class CheckingAccount extends Account
{
    private int canBeOverDrawnFigure;
    private int numberOfFreeWithdrawTransactions;
    private int withdrawalFee;
    private int numberOfWithdrawals;

    /**
     * Initializes the variables in the class
     * @param accountNumber
     * @param accountStatus
     * @param accountName
     * @param accountOwner
     * @param balance
     * @param canBeOverDrawnFigure The figure the Customer can overdraw
     * @param numerOfFreeWithdrawTransactions The specific number of free transactions
     * @param withdrawalFee The price the Customer has to pay to withdraw after the free transactions run out
     */
    public CheckingAccount(int accountNumber, boolean accountStatus, String accountName, String accountOwner, int balance,int canBeOverDrawnFigure, int numerOfFreeWithdrawTransactions, int withdrawalFee) {
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.accountName = accountName;
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.canBeOverDrawnFigure = canBeOverDrawnFigure;
        this.numberOfFreeWithdrawTransactions = numerOfFreeWithdrawTransactions;
        this.withdrawalFee = withdrawalFee;
        this.numberOfWithdrawals = 0;
    }

    /**
     * Overriden function inherited from Account
     * If the account is inactive the Customer can't
     * deposit any fee. If it is active the deposit is successful.
     * @param fee Integer value of the fee the Customer
     *            wants to add to his balance
     */
    @Override
    void deposit(int fee) {
        if(accountStatus == false)
        {
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
     * If the account isn't inactive the Customer
     * can try to withdraw from his account.
     *  The customer can't overdraw over a specific value
     *  and only has a specific number of free transfers
     * @param fee Integer value of the fee the Customer
     *            wants to withdraw from his balance
     */
    @Override
    void withdraw(int fee) {
        int overdrawnBalance = 0 - canBeOverDrawnFigure;
        int checkFinalStatus = balance - fee;
        if(accountStatus == false)
        {
            System.out.println("You cannot withdraw from an inactive account");
        }
        //If the withdraw would exceed the overdrawnBalance
        else if(checkFinalStatus < overdrawnBalance)
        {
            System.out.println("You cannot overdraw this amount from this account");
        }
        //If we reach the number of free withdrawals we add the withdrawal fee
        else if(numberOfWithdrawals >= numberOfFreeWithdrawTransactions)
        {
            balance -= withdrawalFee;
            balance -= fee;
            numberOfWithdrawals++;
        }
        else
        {
            balance -= fee;
            numberOfWithdrawals++;
        }

    }
}
