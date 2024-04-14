/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

/**
 *
 * @author $abit
 */
public class SeqAlerts {
    String alertReciver,alertMsg;

    public SeqAlerts(String alertReciver, String alertMsg) {
        this.alertReciver = alertReciver;
        this.alertMsg = alertMsg;
    }

    public String getAlertReciver() {
        return alertReciver;
    }

    public void setAlertReciver(String alertReciver) {
        this.alertReciver = alertReciver;
    }

    public String getAlertMsg() {
        return alertMsg;
    }

    public void setAlertMsg(String alertMsg) {
        this.alertMsg = alertMsg;
    }

    @Override
    public String toString() {
        return "SeqAlerts{" + "alertReciver=" + alertReciver + ", alertMsg=" + alertMsg + '}';
    }
    
    
}
