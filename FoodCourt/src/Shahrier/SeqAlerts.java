/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import java.io.Serializable;

/**
 *
 * @author $abit
 */
public class SeqAlerts  implements Serializable{
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
        return "Reciver = " + alertReciver +"\n"+ "Message = " + alertMsg;
    }
    
    
}
