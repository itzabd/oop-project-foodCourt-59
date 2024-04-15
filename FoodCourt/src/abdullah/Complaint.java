/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullah;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author User
 */
public class Complaint implements Serializable {
    String NameOfC,cAbout,cUserType,cDetails;
    LocalDate CDate;
    int Id;

    public Complaint(String NameOfC, String cAbout, String cUserType, String cDetails, LocalDate CDate, int Id) {
        this.NameOfC = NameOfC;
        this.cAbout = cAbout;
        this.cUserType = cUserType;
        this.cDetails = cDetails;
        this.CDate = CDate;
        this.Id = Id;
    }

    public String getNameOfC() {
        return NameOfC;
    }

    public void setNameOfC(String NameOfC) {
        this.NameOfC = NameOfC;
    }

    public String getcAbout() {
        return cAbout;
    }

    public void setcAbout(String cAbout) {
        this.cAbout = cAbout;
    }

    public String getcUserType() {
        return cUserType;
    }

    public void setcUserType(String cUserType) {
        this.cUserType = cUserType;
    }

    public String getcDetails() {
        return cDetails;
    }

    public void setcDetails(String cDetails) {
        this.cDetails = cDetails;
    }

    public LocalDate getCDate() {
        return CDate;
    }

    public void setCDate(LocalDate CDate) {
        this.CDate = CDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

  
}
