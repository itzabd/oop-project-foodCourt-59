/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullah;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class Stall implements Serializable {
    public String StallName,StallManagerName,StallType;
    public LocalDate RentFrom,RentTo;
    public String contactNo;

    public Stall(String StallName, String StallManagerName, String StallType, LocalDate RentFrom, LocalDate RentTo, String contactNo) {
        this.StallName = StallName;
        this.StallManagerName = StallManagerName;
        this.StallType = StallType;
        this.RentFrom = RentFrom;
        this.RentTo = RentTo;
        this.contactNo = contactNo;
    }

//   public void readStallList(ObservableList<Stall> StallList) {
//        
//        try {ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StallObject.bin"));
//            while (true) {
//                Stall s = (Stall) ois.readObject();
//                System.out.println("The stall u read: " + s.toString());
//                StallList.add(s);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("File reading done");
//        }
//        System.out.println(StallList);
//        
//
//        }
    public String getStallName() {
        return StallName;
    }

    public void setStallName(String StallName) {
        this.StallName = StallName;
    }

    public String getStallManagerName() {
        return StallManagerName;
    }

    public void setStallManagerName(String StallManagerName) {
        this.StallManagerName = StallManagerName;
    }

    public String getStallType() {
        return StallType;
    }

    public void setStallType(String StallType) {
        this.StallType = StallType;
    }

    public LocalDate getRentFrom() {
        return RentFrom;
    }

    public void setRentFrom(LocalDate RentFrom) {
        this.RentFrom = RentFrom;
    }

    public LocalDate getRentTo() {
        return RentTo;
    }

    public void setRentTo(LocalDate RentTo) {
        this.RentTo = RentTo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Stall{" + "StallName=" + StallName + ", StallManagerName=" + StallManagerName + ", StallType=" + StallType +"/n"
                + ", RentFrom=" + RentFrom + ", RentTo=" + RentTo + ", contactNo=" + contactNo + '}';
    }

    
}
