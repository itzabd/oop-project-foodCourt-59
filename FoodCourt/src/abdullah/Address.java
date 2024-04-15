/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullah;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Address implements Serializable {
    public String HouseNo,BlockNo,StreetNo,Area,Note;
    public String postalCode;
    public String usernameH;

    public Address(String HouseNo, String BlockNo, String StreetNo, String Area, String Note, String postalCode, String usernameH) {
        this.HouseNo = HouseNo;
        this.BlockNo = BlockNo;
        this.StreetNo = StreetNo;
        this.Area = Area;
        this.Note = Note;
        this.postalCode = postalCode;
        this.usernameH = usernameH;
    }

    public String getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(String HouseNo) {
        this.HouseNo = HouseNo;
    }

    public String getBlockNo() {
        return BlockNo;
    }

    public void setBlockNo(String BlockNo) {
        this.BlockNo = BlockNo;
    }

    public String getStreetNo() {
        return StreetNo;
    }

    public void setStreetNo(String StreetNo) {
        this.StreetNo = StreetNo;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getUsernameH() {
        return usernameH;
    }

    public void setUsernameH(String usernameH) {
        this.usernameH = usernameH;
    }

    @Override
    public String toString() {
        return "Address{" + "HouseNo=" + HouseNo + ", BlockNo=" + BlockNo + ", StreetNo=" + StreetNo + ", Area=" + Area + ", Note=" + Note + ", postalCode=" + postalCode + ", usernameH=" + usernameH + '}';
    }

    
    
}
