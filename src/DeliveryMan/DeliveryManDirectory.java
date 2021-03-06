/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeliveryMan;

import DataStore.GenericDirectory;
import Personnel.Address;
import Personnel.PersonDetails;
import Personnel.Role;
import Personnel.UserAccount;
import java.time.Instant;
import java.time.LocalDate;

/**
 *
 * @author Sravya
 */
public class DeliveryManDirectory {
    
    public GenericDirectory<String, DeliveryMan> deliveryManMap; //map for delivery man <id, details>

    public DeliveryManDirectory(){
        this.deliveryManMap = new GenericDirectory<>();
    }
    
    public void addDeliveryMan(DeliveryMan deliveryMan) {
        deliveryManMap.add(deliveryMan.getUserAccount().getUsername(), deliveryMan);
    }
    
    public DeliveryMan addDeliveryMan(
                                String fullName,
                                LocalDate dob,
                                PersonDetails.Gender gender,
                                Address address,
                                String phoneNumber,
                                UserAccount account,
                                int organizationId){
        
        DeliveryMan delMan = new DeliveryMan(fullName, dob, gender, address, phoneNumber, null, account, organizationId);
        deliveryManMap.add(delMan.getPersonDetails().getId(), delMan);
        return delMan;
    }  
    
    public void deleteDeliveryMan(DeliveryMan deliveryMan){
        deliveryManMap.remove(deliveryMan.getPersonDetails().getId());
    }

    public GenericDirectory<String, DeliveryMan> getDeliveryManMap() {
        return deliveryManMap;
    }  
}
    

