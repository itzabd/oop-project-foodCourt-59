/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArifulIslam;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Dessert implements Serializable{
    String stallName, itemName;
    int price;

    public Dessert(String stallName, String itemName, int price) {
        this.stallName = stallName;
        this.itemName = itemName;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dessert{" + "stallName=" + stallName + ", itemName=" + itemName + ", price=" + price + '}';
    }
    
    
    
}
