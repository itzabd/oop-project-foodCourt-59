/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullah;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Policy implements Serializable {
    String Pname, Pdes;
    LocalDate Pdate;

    public Policy(String Pname, String Pdes, LocalDate Pdate) {
        this.Pname = Pname;
        this.Pdes = Pdes;
        this.Pdate = Pdate;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public String getPdes() {
        return Pdes;
    }

    public void setPdes(String Pdes) {
        this.Pdes = Pdes;
    }

    public LocalDate getPdate() {
        return Pdate;
    }

    public void setPdate(LocalDate Pdate) {
        this.Pdate = Pdate;
    }

    @Override
    public String toString() {
        return "Policy{" + "Pname=" + Pname + ", Pdes=" + Pdes + ", Pdate=" + Pdate + '}';
    }
    
    
}
