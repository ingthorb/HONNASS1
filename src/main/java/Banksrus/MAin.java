package Banksrus;
/**
 * Created by Ingthorb on 9/6/2016.
 * Test class for Bankers
 */
public class MAin {
    public static void main(String[] args) {

         Bank b = new Bank();
         Customer cust = new Customer(1,"Ingthor","21.09.1950","Bildsfell3");
         Customer cust2 = new Customer(2,"Jon","12.02.1993","Selfoss");
         Customer cust3 = new Customer(3,"Ari","02.09.1980","Reykjavik");
         FourKAccount fourk = new FourKAccount(1,true,"Savings","Ingthor",1000,cust);
         FourKAccount fourk2 = new FourKAccount(2,false,"public","Ingthor",500000,cust);
         FourKAccount fourk3 = new FourKAccount(3,true,"private","Jon",23000,cust);
         SavingsAccount sav = new SavingsAccount(1,false,"Spare Money","Jon",20000,1);
         SavingsAccount sav2 = new SavingsAccount(1,false,"Spare keys","Ari",20000,1);
         CheckingAccount check = new CheckingAccount(1,true,"Debetkort","Ari",2000,10000,1,200);

        //Banks Test
        System.out.println("Banks tests");
        b.addAccounts(fourk);
        b.addAccounts(fourk2);
        b.addAccounts(fourk3);
        b.addCustomers(cust);
        b.addCustomers(cust2);
        b.addCustomers(cust3);

        b.printAllAccountsForCostumers();
        b.printActiveAccountsForCostumer(cust);
        b.printActiveAccountsForCostumer(cust2);
        b.printActiveAccountsForCostumer(cust3);
        System.out.println("");

        //401K Accounts Tests
        System.out.println("401K Accounts tests");
        fourk.deposit(-100);
        fourk2.deposit(2000);
        fourk.withdraw(200);
        fourk2.withdraw(20000000);
        fourk3.withdraw(900);
        System.out.println("");

        //Savings Account Tests
        System.out.println("Savings Account tests");
        sav.deposit(200);
        sav2.deposit(2000000);
        //System.out.println(sav.accountStatus);
        sav.withdraw(200);
        sav.withdraw(200);
        sav2.withdraw(20000);
        System.out.println("");

        //Checking Account Tests
        System.out.println("Checking Account tests");
        check.deposit(200);
        check.withdraw(2000);
        check.withdraw(200);
        check.withdraw(2000000000);
        System.out.println("");
    }
}
