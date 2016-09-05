import Banksrus.Bank;
import Banksrus.Customer;
import Banksrus.FourKAccount;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ingthor on 5.9.2016.
 */
public class BankersTest {

    private String testForAllAccounts;
    private String testForAllActiveAccounts;
    private FourKAccount fourk = new FourKAccount(1,true,"LogiSucks","Ingthor",1000);
    private FourKAccount fork2 = new FourKAccount(1,false,"KSII","Ingthor",1000);
    private Customer cust = new Customer(1,"Ingthor","21.09.1993","Bildsfell3");

    public static void main(String[] args) {

           }
    public void initTestData()
    {

        String testForAllAccounts = ("All accounts\n" +
                "Account Name: LogiSucks\n" +
                "Account Owner: Ingthor\n" +
                "Account Number: 1\n" +
                "Account Status: true\n" +
                "Account balance: 1000\n" +
                "\n" +
                "Account Name: KSII\n" +
                "Account Owner: Ingthor\n" +
                "Account Number: 1\n" +
                "Account Status: false\n" +
                "Account balance: 1000\n" +
                "\n");
        String testForAllActiveAccounts = ("All active accounts\n" +
                "Account Name: LogiSucks\n" +
                "Account Owner: Ingthor\n" +
                "Account Number: 1\n" +
                "Account Status: true\n" +
                "Account balance: 1000\n" +
                "\n");

    }
    @Test
    public void testSalaryCalculatorUnderPayed()
    {
        initTestData();
        Bank ban = new Bank();
        ban.addAccounts(fourk);
        ban.addAccounts(fork2);

       // assertEquals(testForAllAccounts, ban.printAllAccountsForCostumers());

    }
}
