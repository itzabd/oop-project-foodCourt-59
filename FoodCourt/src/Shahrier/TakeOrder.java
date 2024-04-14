/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import java.time.LocalDate;

/**
 *
 * @author $abit
 */
public class TakeOrder {
    String orderID,stallName,itemName,delivetyTime;
    LocalDate orderTakingDate;
    int itemQuantity,perItemPrice,totalPrice;

    public TakeOrder() {
    }

    public TakeOrder(String orderID, String stallName, String itemName, String delivetyTime, LocalDate orderTakingDate, int itemQuantity, int perItemPrice, int totalPrice) {
        this.orderID = orderID;
        this.stallName = stallName;
        this.itemName = itemName;
        this.delivetyTime = delivetyTime;
        this.orderTakingDate = orderTakingDate;
        this.itemQuantity = itemQuantity;
        this.perItemPrice = perItemPrice;
        this.totalPrice = totalPrice;
    }
    
    
    
    public TakeOrder(String orderID, String stallName, String itemName, String delivetyTime, LocalDate orderTakingDate, int itemQuantity, int perItemPrice) {
        this.orderID = orderID;
        this.stallName = stallName;
        this.itemName = itemName;
        this.delivetyTime = delivetyTime;
        this.orderTakingDate = orderTakingDate;
        this.itemQuantity = itemQuantity;
        this.perItemPrice = perItemPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDelivetyTime() {
        return delivetyTime;
    }

    public void setDelivetyTime(String delivetyTime) {
        this.delivetyTime = delivetyTime;
    }

    public LocalDate getOrderTakingDate() {
        return orderTakingDate;
    }

    public void setOrderTakingDate(LocalDate orderTakingDate) {
        this.orderTakingDate = orderTakingDate;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getPerItemPrice() {
        return perItemPrice;
    }

    public void setPerItemPrice(int perItemPrice) {
        this.perItemPrice = perItemPrice;
    }
    
    public int totalPriceCalculation(){
        int r = 0;
        r=itemQuantity*perItemPrice;
        return r;
    }
    
    @Override
    public String toString() {
        return "TakeOrder{" + "orderID=" + orderID + ", stallName=" + stallName + ", itemName=" + itemName + ", delivetyTime=" + delivetyTime + ", orderTakingDate=" + orderTakingDate + ", itemQuantity=" + itemQuantity + ", perItemPrice=" + perItemPrice + ", totalPrice=" + totalPrice + '}';
    }
    
    
    
    
    
    
}
