package Banksrus;

/**
 * Created by Ingthor on 31.8.2016.
 */
public class CheckingAccount extends Account
{
    private int canBeOverDrawnFigure;
    private int freeWithdrawTransactions;
    private int withdrawalFee;
    private int numberOfWithdrawals;

    public CheckingAccount() {
    }

    public CheckingAccount(int canBeOverDrawnFigure, int freeWithdrawTransactions, int withdrawalFee, int numberOfWithdrawals) {
        this.canBeOverDrawnFigure = canBeOverDrawnFigure;
        this.freeWithdrawTransactions = freeWithdrawTransactions;
        this.withdrawalFee = withdrawalFee;
        this.numberOfWithdrawals = numberOfWithdrawals;
    }

    @Override
    void deposit(int fee) {
        balance += fee;

    }

    @Override
    void withdraw(int fee) {
        int balance = 0;
        int overdrawnBalance = 0 -canBeOverDrawnFigure;
        if(balance <= overdrawnBalance)
        {
            System.out.println("You cannot overdraw from this account");
        }
        if(numberOfWithdrawals >= freeWithdrawTransactions)
        {
            balance -= withdrawalFee;
        }
        numberOfWithdrawals++;
    }
}
