/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import Personnel.Address;
import Personnel.Person;
import Personnel.Role;
import Personnel.UserAccount;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Ankur Bywar
 */
public class Patient extends Person {

    public Patient(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        super(fullName, dob, gender, address, phoneNumber, account, Role.PATIENT);
    }
    
}
