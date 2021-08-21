/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeliveryMan;

import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.PersonRatings;
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
public class DeliveryMan implements Person {
    private PersonDetails deliveryManDetails;
    private PersonRatings personRatings;
    
    public DeliveryMan(
            String fullName,
            LocalDate dob,
            Gender gender,
            Address address,
            String phoneNumber,
            Icon logoImage,
            UserAccount account,
            int organizationId){
        
        deliveryManDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DELIVERY_MAN, logoImage, organizationId);
        this.personRatings = new PersonRatings();
    }
    
    public DeliveryMan(
            String fullName,
            LocalDate dob,
            Gender gender,
            Address address,
            String phoneNumber,
            Icon logoImage,
            UserAccount account,
            int organizationId,
            String emailId){
        
        deliveryManDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DELIVERY_MAN, logoImage, organizationId, emailId);
        this.personRatings = new PersonRatings();
    }
    
    @Override
    public UserAccount getUserAccount(){
        return deliveryManDetails.getUserAccount();
    }
    
    @Override
    public Role getRole(){
        return deliveryManDetails.getRole();
    }

    public PersonDetails getDeliveryManDetails() {
        return deliveryManDetails;
    }

    @Override
    public PersonDetails getPersonDetails() {
        return deliveryManDetails;
    }

    @Override
    public int getOrganizationId() {
        return this.deliveryManDetails.getOrganizationId();
    }

    @Override
    public void updateDetails(PersonDetails newPersonalDetails) {
        this.deliveryManDetails = newPersonalDetails;
    }
    
    @Override
    public void addRating(Rating rating) {
        personRatings.addRating(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return personRatings.getAllRatings();
    }
}
