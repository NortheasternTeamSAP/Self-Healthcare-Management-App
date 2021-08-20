/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insurance;

import Doctor.*;
import DataStore.Appointment;
import Organization.Organization;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.Role;
import Personnel.UserAccount;
import Utils.Rating;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;

/**
 *
 * @author Ankur Bywar
 */
public class InsuranceProviderRepresentative implements Person {
    private PersonDetails insuranceProviderRepDetails;
    private Organization organization;
    
    public InsuranceProviderRepresentative(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber,
            Icon logoImage,
            UserAccount account) {
        
        insuranceProviderRepDetails = new PersonDetails(fullName, dob, gender, address, 
                phoneNumber, account, Role.INSURANCE_PROVIDER_REP, logoImage);
    }
    
     public InsuranceProviderRepresentative(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber,
            Icon logoImage,
            UserAccount account,
            int organizationId) {
        
        insuranceProviderRepDetails = new PersonDetails(fullName, dob, gender, address, 
                phoneNumber, account, Role.INSURANCE_PROVIDER_REP, logoImage,organizationId );
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    
    @Override
    public UserAccount getUserAccount() {
        return insuranceProviderRepDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return insuranceProviderRepDetails.getRole();
    }

    @Override
    public PersonDetails getPersonDetails() {
        return insuranceProviderRepDetails;
    }

    @Override
    public int getOrganizationId() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getPersonDetails().getOrganizationId();
    }
    
    @Override
    public void updateDetails(PersonDetails newInsuranceProviderRepDetails) {
        this.insuranceProviderRepDetails = newInsuranceProviderRepDetails;
    }

    @Override
    public void addRating(Rating rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rating> getAllRatings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
