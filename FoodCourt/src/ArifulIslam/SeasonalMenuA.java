/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArifulIslam;

/**
 *
 * @author HP
 */
public class SeasonalMenuA {
    String stallNameA, newSeasonalItemName;
    int priceA;

    public SeasonalMenuA(String stallNameA, String newSeasonalItemName, int priceA) {
        this.stallNameA = stallNameA;
        this.newSeasonalItemName = newSeasonalItemName;
        this.priceA = priceA;
    }

    public String getStallNameA() {
        return stallNameA;
    }

    public void setStallNameA(String stallNameA) {
        this.stallNameA = stallNameA;
    }

    public String getNewSeasonalItemName() {
        return newSeasonalItemName;
    }

    public void setNewSeasonalItemName(String newSeasonalItemName) {
        this.newSeasonalItemName = newSeasonalItemName;
    }

    public int getPriceA() {
        return priceA;
    }

    public void setPriceA(int priceA) {
        this.priceA = priceA;
    }

    @Override
    public String toString() {
        return "SeasonalMenuA{" + "stallNameA=" + stallNameA + ", newSeasonalItemName=" + newSeasonalItemName + ", priceA=" + priceA + '}';
    }
    
    
}
