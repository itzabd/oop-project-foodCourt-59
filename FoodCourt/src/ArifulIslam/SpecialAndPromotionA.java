/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArifulIslam;

/**
 *
 * @author HP
 */
public class SpecialAndPromotionA {
    String stallName, specialitemName, offer;
    int price;

    public SpecialAndPromotionA(String stallName, String specialitemName, String offer, int price) {
        this.stallName = stallName;
        this.specialitemName = specialitemName;
        this.offer = offer;
        this.price = price;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getSpecialitemName() {
        return specialitemName;
    }

    public void setSpecialitemName(String specialitemName) {
        this.specialitemName = specialitemName;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SpecialAndPromotionA{" + "stallName=" + stallName + ", specialitemName=" + specialitemName + ", offer=" + offer + ", price=" + price + '}';
    }
    
    
    
    
}
