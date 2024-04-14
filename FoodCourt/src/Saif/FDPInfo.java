/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Saif;

import java.io.Serializable;

/**
 *
 * @author sakib
 */
public class FDPInfo implements Serializable {
    String name = "", phoneNumber = "",email = "" ,deliveryType = "" , deliveryShift = "",startDate = "",endDate = "";
    
    public FDPInfo(){};
    
    public FDPInfo(String name, String phoneNumber, String email, String deliveryType, String deliveryShift, String startDate, String endDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.deliveryType = deliveryType;
        this.deliveryShift = deliveryShift;
        
        this.startDate = startDate;
        this.endDate = endDate;
    }
    

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDeliveryShift() {
        return deliveryShift;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
    
    @Override
    public String toString() {
        return "FDPInfo{" + "name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", deliveryType=" + deliveryType + ", deliveryShift=" + deliveryShift + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
    
    
    
}
