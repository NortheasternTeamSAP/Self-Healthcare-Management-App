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
import java.time.LocalDate;

/**
 *
 * @author Sravya
 */
public class DeliveryManDirectory {
    
    public static GenericDirectory<String, DeliveryMan> deliveryManMap; //map for delivery man <id, details>
    private int id;
    
    public DeliveryManDirectory(){
        this.deliveryManMap = new GenericDirectory<>();
        id = 0;
    }
    
    public DeliveryMan addDeliveryMan(
                                String fullName,
                                LocalDate dob,
                                PersonDetails.Gender gender,
                                Address address,
                                String phoneNumber,
                                UserAccount account){
        
        DeliveryMan delMan = new DeliveryMan(fullName, dob, gender, address, phoneNumber, account);
        DeliveryManDirectory.deliveryManMap.add(Integer.toString(id), delMan);
        id += 1;
        return delMan;
    }  
    
    public void deleteDeliveryMan(DeliveryMan deliveryMan){
        DeliveryManDirectory.deliveryManMap.remove(Integer.toString(id));
    }

    public static GenericDirectory<String, DeliveryMan> getDeliveryManMap() {
        return deliveryManMap;
    }  
}
    

