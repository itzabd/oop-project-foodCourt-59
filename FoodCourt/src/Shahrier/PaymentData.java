/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author $abit
 */
public class PaymentData implements Serializable {
    String stallName;
    LocalDate paymentDate;
    int totalAmount,recAmount,dueAmount,cotractPaymentAmount;

    public PaymentData(String stallName, int totalAmount, int recAmount, int dueAmount, int cotractPaymentAmount) {
        this.stallName = stallName;
        this.totalAmount = totalAmount;
        this.recAmount = recAmount;
        this.dueAmount = dueAmount;
        this.cotractPaymentAmount = cotractPaymentAmount;
    }
    
    

    public PaymentData(String stallName, int totalAmount, int recAmount, int dueAmount) {
        this.stallName = stallName;
        this.totalAmount = totalAmount;
        this.recAmount = recAmount;
        this.dueAmount = dueAmount;
    }

    public int getCotractPaymentAmount() {
        return cotractPaymentAmount;
    }

    public void setCotractPaymentAmount(int cotractPaymentAmount) {
        this.cotractPaymentAmount = cotractPaymentAmount;
    }
    
    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(int recAmount) {
        this.recAmount = recAmount;
    }

    public int getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(int dueAmount) {
        this.dueAmount = dueAmount;
    }

    @Override
    public String toString() {
        return "PaymentData{" + "stallName=" + stallName + ", paymentDate=" + paymentDate + ", totalAmount=" + totalAmount + ", recAmount=" + recAmount + ", dueAmount=" + dueAmount + '}';
    }
    
    
}
