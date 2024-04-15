/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author $abit
 */
public class ContractData implements Serializable {
    LocalDate startTime,endTime;
    String contractStall,contractDuration;
    int advancePay;

    public ContractData(LocalDate startTime, LocalDate endTime, String contractStall, int advancePay) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.contractStall = contractStall;
        this.advancePay = advancePay;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getContractStall() {
        return contractStall;
    }

    public void setContractStall(String contractStall) {
        this.contractStall = contractStall;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }

    public int getAdvancePay() {
        return advancePay;
    }

    public void setAdvancePay(int advancePay) {
        this.advancePay = advancePay;
    }

    @Override
    public String toString() {
        return "ContractData{" + "startTime=" + startTime + ", endTime=" + endTime + ", contractStall=" + contractStall + ", contractDuration=" + contractDuration + ", advancePay=" + advancePay + '}';
    }
    
    
    
}
