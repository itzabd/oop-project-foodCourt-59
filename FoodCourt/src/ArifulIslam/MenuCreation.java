/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArifulIslam;

// aaaabbbb
/**
 *
 * @author HP 
 */
public class MenuCreation {
    String stallName, itemName;
    int price;

    public MenuCreation(String stallName, String itemName, int price) {
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
        return "MenuCreation{" + "stallName=" + stallName + ", itemName=" + itemName + ", price=" + price + '}';
    }
    
    
    
}
