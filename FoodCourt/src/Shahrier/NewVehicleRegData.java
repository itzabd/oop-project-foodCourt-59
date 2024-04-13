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
public class NewVehicleRegData {
    LocalDate regDate;
    int regDuration;
    String vehicleModel,vehicleLicenseNum,vehicleOwnerName,vehicleOwnerContact;

    public NewVehicleRegData(LocalDate regDate, int regDuration, String vehicleModel, String vehicleLicenseNum, String vehicleOwnerName, String vehicleOwnerContact) {
        this.regDate = regDate;
        this.regDuration = regDuration;
        this.vehicleModel = vehicleModel;
        this.vehicleLicenseNum = vehicleLicenseNum;
        this.vehicleOwnerName = vehicleOwnerName;
        this.vehicleOwnerContact = vehicleOwnerContact;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public int getRegDuration() {
        return regDuration;
    }

    public void setRegDuration(int regDuration) {
        this.regDuration = regDuration;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleLicenseNum() {
        return vehicleLicenseNum;
    }

    public void setVehicleLicenseNum(String vehicleLicenseNum) {
        this.vehicleLicenseNum = vehicleLicenseNum;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public String getVehicleOwnerContact() {
        return vehicleOwnerContact;
    }

    public void setVehicleOwnerContact(String vehicleOwnerContact) {
        this.vehicleOwnerContact = vehicleOwnerContact;
    }

    @Override
    public String toString() {
        return "NewVehicleRegData{" + "regDate=" + regDate + ", regDuration=" + regDuration + ", vehicleModel=" + vehicleModel + ", vehicleLicenseNum=" + vehicleLicenseNum + ", vehicleOwnerName=" + vehicleOwnerName + ", vehicleOwnerContact=" + vehicleOwnerContact + '}';
    }
    
    
    
}
