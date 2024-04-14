/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import java.io.Serializable;

/**
 *
 * @author $abit
 */
public class ParkingAreaVechileData implements Serializable{
    String vhInfoLicenseNum,vhInfoOwnerName,vhInfoOwnerContact,vhInfoComplain;
    int vhInfoParkingTime,vhInfoperMinCost,vhInfoParkingCost;

    public ParkingAreaVechileData(String vhInfoLicenseNum, String vhInfoOwnerName, String vhInfoOwnerContact, String vhInfoComplain, int vhInfoParkingTime, int vhInfoperMinCost, int vhInfoParkingCost) {
        this.vhInfoLicenseNum = vhInfoLicenseNum;
        this.vhInfoOwnerName = vhInfoOwnerName;
        this.vhInfoOwnerContact = vhInfoOwnerContact;
        this.vhInfoComplain = vhInfoComplain;
        this.vhInfoParkingTime = vhInfoParkingTime;
        this.vhInfoperMinCost = vhInfoperMinCost;
        this.vhInfoParkingCost = vhInfoParkingCost;
    }

    public String getVhInfoLicenseNum() {
        return vhInfoLicenseNum;
    }

    public void setVhInfoLicenseNum(String vhInfoLicenseNum) {
        this.vhInfoLicenseNum = vhInfoLicenseNum;
    }

    public String getVhInfoOwnerName() {
        return vhInfoOwnerName;
    }

    public void setVhInfoOwnerName(String vhInfoOwnerName) {
        this.vhInfoOwnerName = vhInfoOwnerName;
    }

    public String getVhInfoOwnerContact() {
        return vhInfoOwnerContact;
    }

    public void setVhInfoOwnerContact(String vhInfoOwnerContact) {
        this.vhInfoOwnerContact = vhInfoOwnerContact;
    }

    public String getVhInfoComplain() {
        return vhInfoComplain;
    }

    public void setVhInfoComplain(String vhInfoComplain) {
        this.vhInfoComplain = vhInfoComplain;
    }

    public int getVhInfoParkingTime() {
        return vhInfoParkingTime;
    }

    public void setVhInfoParkingTime(int vhInfoParkingTime) {
        this.vhInfoParkingTime = vhInfoParkingTime;
    }

    public int getVhInfoperMinCost() {
        return vhInfoperMinCost;
    }

    public void setVhInfoperMinCost(int vhInfoperMinCost) {
        this.vhInfoperMinCost = vhInfoperMinCost;
    }

    public int getVhInfoParkingCost() {
        return vhInfoParkingCost;
    }

    public void setVhInfoParkingCost(int vhInfoParkingCost) {
        this.vhInfoParkingCost = vhInfoParkingCost;
    }

    @Override
    public String toString() {
        return "ParkingAreaVechileData{" + "vhInfoLicenseNum=" + vhInfoLicenseNum + ", vhInfoOwnerName=" + vhInfoOwnerName + ", vhInfoOwnerContact=" + vhInfoOwnerContact + ", vhInfoComplain=" + vhInfoComplain + ", vhInfoParkingTime=" + vhInfoParkingTime + ", vhInfoperMinCost=" + vhInfoperMinCost + ", vhInfoParkingCost=" + vhInfoParkingCost + '}';
    }
    
    public int tCostOfParking(){
        int result = 0;
        result = vhInfoParkingTime*vhInfoperMinCost;
        return result;
    }
    
}
