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
            UserAccount account){
        
        deliveryManDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DELIVERY_MAN); 
    }
    
    @Override
    public UserAccount getUserAccount(){
        return deliveryManDetails.getUserAccount();
    }
    
    @Override
    public Role getRole(){
        return deliveryManDetails.getRole();
    }

    @Override
    public PersonDetails getDeliveryManDetails() {
        return deliveryManDetails;
    }
}