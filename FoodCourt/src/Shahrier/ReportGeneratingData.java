/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Dell Latitude
 */
public class ReportGeneratingData implements Serializable{
    LocalDate reportDate;
    int sessionStartTime,sessionEndTime,exitTime;
    String selectEmpID,empRole,empfeedBack;

    public ReportGeneratingData(LocalDate reportDate, int sessionStartTime, int sessionEndTime, int exitTime, String selectEmpID, String empRole, String empfeedBack) {
        this.reportDate = reportDate;
        this.sessionStartTime = sessionStartTime;
        this.sessionEndTime = sessionEndTime;
        this.exitTime = exitTime;
        this.selectEmpID = selectEmpID;
        this.empRole = empRole;
        this.empfeedBack = empfeedBack;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public int getSessionStartTime() {
        return sessionStartTime;
    }

    public void setSessionStartTime(int sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    public int getSessionEndTime() {
        return sessionEndTime;
    }

    public void setSessionEndTime(int sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public String getSelectEmpID() {
        return selectEmpID;
    }

    public void setSelectEmpID(String selectEmpID) {
        this.selectEmpID = selectEmpID;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public String getEmpfeedBack() {
        return empfeedBack;
    }

    public void setEmpfeedBack(String empfeedBack) {
        this.empfeedBack = empfeedBack;
    }

    @Override
    public String toString() {
        return "Report Date : " + reportDate + "\n" +
               "Employee ID : " + selectEmpID + "\n"+
               "Employee Role : " + empRole + "\n"+
               "Session Start time : " + sessionStartTime +" O'Clock"+ "\n"+
               "Session End Time : " + sessionEndTime+" O'Clock" + "\n" +
               "Exit Time : " + exitTime+" O'Clock" + "\n" +
               "Feedback : " + empfeedBack+ "\n"+ "\n" ;
    }
    
    
}
