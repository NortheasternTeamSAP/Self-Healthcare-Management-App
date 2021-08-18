/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import DataStore.GenericDirectory;
import Personnel.Address;
import Personnel.PersonDetails;
import Personnel.UserAccount;
import java.time.LocalDate;

/**
 *
 * @author sravy
 */
public class PharmacistDirectory {
    public GenericDirectory<String, Pharmacist> pharmacistMap; //map for pharmacist <id, details>
    private int id;
    
    public PharmacistDirectory(){
        this.pharmacistMap = new GenericDirectory<>();
        id = 0;
    }
    
    public void addPharmacist(Pharmacist pharmacist) {
        pharmacistMap.add(pharmacist.getUserAccount().getUsername(), pharmacist);
    }
    
    public Pharmacist addPharmacist(String fullName,
                                LocalDate dob,
                                PersonDetails.Gender gender,
                                Address address,
                                String phoneNumber,
                                UserAccount account){
        
        Pharmacist pharmacist = new Pharmacist(
                                        fullName, 
                                        dob, 
                                        gender, 
                                        address, 
                                        phoneNumber, 
                                        null,
                                        account,
                                        -1);
        pharmacistMap.add(Integer.toString(id), pharmacist);
        id += 1;
        return pharmacist;
    }
    
    public void deletePharmacist(Pharmacist pharmacist){
        pharmacistMap.remove(Integer.toString(id));
    }

    public GenericDirectory<String, Pharmacist> getPharmacistMap() {
        return pharmacistMap;
    }
}
