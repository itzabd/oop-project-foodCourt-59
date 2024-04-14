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
    String cName,cAbout,cUserType;
    LocalDate CDate;
    int Id;

    public Complaint(String cName, String cAbout, String cUserType, LocalDate CDate, int Id) {
        this.cName = cName;
        this.cAbout = cAbout;
        this.cUserType = cUserType;
        this.CDate = CDate;
        this.Id = Id;
    }
    

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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
