
package Saif;

import java.io.Serializable;


public class Menu implements Serializable {
    String stallName = "" ,foodName = "" ,preferredTime  ="" ;
    String quantity = "";
    String costPerUnit = "";

    public Menu(String stallName, String foodName, String quantity, String preferredTime, String costPerUnit) {
        this.stallName = stallName;
        this.foodName = foodName;
        this.quantity = quantity;
        this.preferredTime = preferredTime;
        this.costPerUnit = costPerUnit;
    }

    public String getStall() {
        return stallName;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPreferredTime() {
        return preferredTime;
    }

    public String getCostPerUnit() {
        return costPerUnit;
    }
    
}
