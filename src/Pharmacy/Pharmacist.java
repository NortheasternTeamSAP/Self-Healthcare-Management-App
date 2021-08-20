/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.Role;
import Personnel.UserAccount;
import Utils.Rating;
import java.time.LocalDate;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author Sravya
 */
public class Pharmacist implements Person{
    private PersonDetails pharmacistDetails;
    
    public Pharmacist(
            String fullName,
            LocalDate dob,
            Gender gender,
            Address address,
            String phoneNumber,
            Icon logoImage,
            UserAccount account,
            int organizationId){

        pharmacistDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.PHARMACIST, logoImage, organizationId);
    }
    
    @Override
    public UserAccount getUserAccount(){
        return pharmacistDetails.getUserAccount();
    }
    
    @Override
    public Role getRole(){
        return pharmacistDetails.getRole();
    }

    @Override
    public PersonDetails getPersonDetails() {
        return pharmacistDetails;
    }
  
    @Override
    public String toString() {
        return getPersonDetails().getFullName();
    }

    @Override
    public int getOrganizationId() {
        return this.pharmacistDetails.getOrganizationId();
    }
    
    @Override
    public void updateDetails(PersonDetails newPharmacistDetails) {
        this.pharmacistDetails = newPharmacistDetails;
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
