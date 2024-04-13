/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import java.io.Serializable;

/**
 *
 * @author Dell Latitude
 */
public class EmpManagementData implements Serializable{
    String empName,empId,empType;
    int empEntryTime,empSessionExpieryTime;

    public EmpManagementData(String empName, String empId, String empType, int empEntryTime, int empSessionExpieryTime) {
        this.empName = empName;
        this.empId = empId;
        this.empType = empType;
        this.empEntryTime = empEntryTime;
        this.empSessionExpieryTime = empSessionExpieryTime;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public int getEmpEntryTime() {
        return empEntryTime;
    }

    public void setEmpEntryTime(int empEntryTime) {
        this.empEntryTime = empEntryTime;
    }

    public int getEmpSessionExpieryTime() {
        return empSessionExpieryTime;
    }

    public void setEmpSessionExpieryTime(int empSessionExpieryTime) {
        this.empSessionExpieryTime = empSessionExpieryTime;
    }

    
    
    
}
