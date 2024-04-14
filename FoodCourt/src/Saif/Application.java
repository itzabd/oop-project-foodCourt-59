/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Saif;

import java.io.Serializable;

/**
 *
 * @author sakib
 */
public class Application implements Serializable {
    String applicationBody;

    public Application(String applicationBody) {
        this.applicationBody = applicationBody;
    }

    public String getApplicationBody() {
        return applicationBody;
    }

    @Override
    public String toString() {
        return "Application{" + "applicationBody=" + applicationBody + '}';
    }
    
    
}
