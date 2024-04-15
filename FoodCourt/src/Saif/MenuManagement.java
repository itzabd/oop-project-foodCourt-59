
package Saif;

import java.io.Serializable;


public class MenuManagement implements Serializable {
    String stallName =""   ,foodName ="" ,addOffer = "", price = "";

    public MenuManagement(String addOffer) {
        this.addOffer = addOffer;
    }


    
    
    public MenuManagement(String stallName, String foodName, String addOffer, String price) {
        this.stallName = stallName;
        this.foodName = foodName;
        this.addOffer = addOffer;
        this.price = price;
    }
    public MenuManagement(String stallName,String foodName, String price) {

        this.foodName = foodName;
        this.price = price;
    }
    

    public String getStallName() {
        return stallName;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getAddOffer() {
        return addOffer;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MenuManagement{" + "stallName=" + stallName + ", foodName=" + foodName + ", addOffer=" + addOffer + ", price=" + price + '}';
    }
    
    
}
