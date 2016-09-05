package Banksrus;

import java.util.Date;

/**
 * Created by Ingthor on 31.8.2016.
 */
public class Customer {

    private int customerId;
    private String customerName;
    private String customerDateOfBirth;
    protected String customerAddress;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerDateOfBirth, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
