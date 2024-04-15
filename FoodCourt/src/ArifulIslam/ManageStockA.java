/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArifulIslam;

/**
 *
 * @author HP
 */
public class ManageStockA {
    String stallName, productName;          // Field create kora hoyece
    int quantity;

    public ManageStockA(String stallName, String productName, int quantity) {
        this.stallName = stallName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ManageStockA{" + "stallName=" + stallName + ", productName=" + productName + ", quantity=" + quantity + '}';
    }
    
    
    
}
