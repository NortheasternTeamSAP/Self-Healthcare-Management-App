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
import Personnel.Role;
import Personnel.UserAccount;
import java.time.LocalDate;
import javax.swing.Icon;

/**
 *
 * @author Sravya
 */
public class DeliveryMan implements Person {
    private PersonDetails deliveryManDetails;
    
    public DeliveryMan(
            String fullName,
            LocalDate dob,
            Gender gender,
            Address address,
            String phoneNumber,
            Icon logoImage,
            UserAccount account){
        
        deliveryManDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DELIVERY_MAN, logoImage); 
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
}
