package Banksrus;

/**
 * Created by Ingthor on 31.8.2016.
 */
public class CheckingAccount extends Account
{
    private int canBeOverDrawnFigure;
    private int numberOfFreeWithdrawTransactions;
    private int withdrawalFee;
    private int numberOfWithdrawals;

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
        int overdrawnBalance = 0 - canBeOverDrawnFigure;
        int checkFinalStatus = balance - fee;
        if(accountStatus == false)
        {
            System.out.println("You cannot withdraw from an inactive account");
        }
        //If the withdraw would exceed the overdrawnBalance
        else if(checkFinalStatus < overdrawnBalance)
        {
            System.out.println("You cannot overdraw from this account");
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
