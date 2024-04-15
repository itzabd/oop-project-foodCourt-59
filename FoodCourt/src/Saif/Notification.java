/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Saif;

/**
 *
 * @author sakib
 */
public class Notification {
    String customerId,customerName,customerNumber,customerPreferredTime;

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerPreferredTime() {
        return customerPreferredTime;
    }

    public Notification(String customerId, String customerName, String customerNumber, String customerPreferredTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerPreferredTime = customerPreferredTime;
    }
    
}
