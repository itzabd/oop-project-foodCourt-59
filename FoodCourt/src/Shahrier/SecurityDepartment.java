/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shahrier;

import abdullah.User;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class SecurityDepartment extends User implements Serializable {
    
    public SecurityDepartment(String username, String email, String name, String password, String contNo, String gender, String usertype, int id, LocalDate dateOfBirth) {
        super(username, email, name, password, contNo, gender, usertype, id, dateOfBirth);
    }
    
}
