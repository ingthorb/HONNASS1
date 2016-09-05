package Salarycomp;

import java.util.DoubleSummaryStatistics;

/**
 * Created by Ingthor on 30.8.2016.
 */

public class SalaryCalculator {
    private static int MAX = 60;
    private static int EXTRATIME = 40;
    private static double BASEPAY = 500;
    private static String LOWBASEPAY = "The base pay is too low";
    private static String TOOMANYHOURS = "Too many hours";

    public String calculatePay(double pay, double hours)
    {
        double totalSalary = 0;
        double count = 0;
            if (pay < BASEPAY) {
                return LOWBASEPAY;
               // throw new ErrorException("The base pay cannot be under 500kr");
            }
            if (hours > MAX) {
                return TOOMANYHOURS;
                //throw new ErrorException("The employee can't work more than 60 hours");
            }
            if (hours > EXTRATIME) {
                for (int i = 0; i <= hours; i++) {
                    if (i > EXTRATIME) {
                        count += 1;
                    }
                }
                count = count * 1.5;
                totalSalary = pay * 40;
                totalSalary += pay * count;
            } else {
                totalSalary = hours * pay;
            }

        //System.out.println(totalSalary);
        return Double.toString(totalSalary);
    }
}

