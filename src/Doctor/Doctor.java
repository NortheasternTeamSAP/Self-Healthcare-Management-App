/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.Role;
import Personnel.UserAccount;
import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class Doctor implements Person {
    private PersonDetails doctorDetails;
    private String speciality;
    
    public Doctor(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        
        doctorDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DOCTOR);
        speciality = "Unknown";
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public UserAccount getUserAccount() {
        return doctorDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return doctorDetails.getRole();
    }

    @Override
    public PersonDetails getPersonDetails() {
        return doctorDetails;
    }
}
