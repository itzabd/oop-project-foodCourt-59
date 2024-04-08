/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import java.io.Serializable;

/**
 *
 * @author Dell Latitude
 */
public class SupplierItem implements Serializable{
    String supItemName;
    int supItemQuantity,supPerItemPrice;

    public SupplierItem(String supItemName, int supItemQuantity, int supPerItemPrice) {
        this.supItemName = supItemName;
        this.supItemQuantity = supItemQuantity;
        this.supPerItemPrice = supPerItemPrice;
    }

    public String getSupItemName() {
        return supItemName;
    }

    public void setSupItemName(String supItemName) {
        this.supItemName = supItemName;
    }

    public int getSupItemQuantity() {
        return supItemQuantity;
    }

    public void setSupItemQuantity(int supItemQuantity) {
        this.supItemQuantity = supItemQuantity;
    }

    public int getSupPerItemPrice() {
        return supPerItemPrice;
    }

    public void setSupPerItemPrice(int supPerItemPrice) {
        this.supPerItemPrice = supPerItemPrice;
    }

    @Override
    public String toString() {
        return "Item Name = " + supItemName + "\n"+"Item Quantity = " + supItemQuantity+ "\n" + "Per Item Price = " + supPerItemPrice+ "\n";
    }
}
