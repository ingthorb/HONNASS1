import Salarycomp.SalaryCalculator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ingthor on 31.8.2016.
 * Testing the SalaryCalculator class
 */
public class SalaryUnitTest extends SalaryCalculator {

   private int basePayEmployee1,basePayEmployee2,basePayEmployee3;
   private int hoursEmployee1,hoursEmployee2,hoursEmployee3;

   /**
    * Initiating the variables above with the given values from
    * the assignment
    */
   public void employees()
   {
      basePayEmployee1 = 450;
      basePayEmployee2 = 900;
      basePayEmployee3 = 1500;

      hoursEmployee1 = 35;
      hoursEmployee2 = 47;
      hoursEmployee3 = 73;
   }

   /**
    * Testing to make sure that the error message gets returned
    */
   @Test
   public void testSalaryCalculatorUnderPayed()
   {
      employees();
      SalaryCalculator salary = new SalaryCalculator();
      String mess ="The base pay is too low";
      assertEquals(mess, salary.calculatePay(basePayEmployee1, hoursEmployee1));
   }

   /**
    * Testing to make sure the salary is correctly calculated
    */
   @Test
   public void testSalaryCalculatorOverTime()
   {
      employees();
      SalaryCalculator salary = new SalaryCalculator();
      assertEquals("45450.0", salary.calculatePay(basePayEmployee2, hoursEmployee2));
   }

   /**
    * Testing to make sure the error message is displayed
    */
   @Test
   public void testSalaryCalculatorTooMuchOverTime()
   {
      employees();
      SalaryCalculator salary = new SalaryCalculator();
      String mess2 = "Too many hours";
      assertEquals(mess2, salary.calculatePay(basePayEmployee3, hoursEmployee3));
   }
}
