/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import Personnel.Address;
import Personnel.Person;
import Personnel.Role;
import Personnel.UserAccount;
import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class Doctor extends Person {
    public Doctor(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        super(fullName, dob, gender, address, phoneNumber, account, Role.DOCTOR);
    }
}
