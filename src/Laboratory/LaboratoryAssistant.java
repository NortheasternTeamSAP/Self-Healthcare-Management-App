/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratory;

import Insurance.*;
import Doctor.*;
import DataStore.Appointment;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.Role;
import Personnel.UserAccount;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Ankur Bywar
 */
public class LaboratoryAssistant implements Person {
    private PersonDetails labAssistantDetails;
    
    public LaboratoryAssistant(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        
        labAssistantDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.INSURANCE_PROVIDER_REP);
    }

    @Override
    public UserAccount getUserAccount() {
        return labAssistantDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return labAssistantDetails.getRole();
    }

    @Override
    public PersonDetails getPersonDetails() {
        return labAssistantDetails;
    }
}
