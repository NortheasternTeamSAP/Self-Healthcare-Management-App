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
import Utils.IdProvider;
import java.time.Instant;
import java.time.LocalDate;

/**
 *
 * @author sravy
 */
public class PharmacistDirectory {
    public GenericDirectory<String, Pharmacist> pharmacistMap; //map for pharmacist <id, details>
    
    public PharmacistDirectory(){
        this.pharmacistMap = new GenericDirectory<>();
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
        long id = IdProvider.getUUID();
        pharmacistMap.add(pharmacist.getPersonDetails().getId(), pharmacist);
        return pharmacist;
    }
    
    public void deletePharmacist(Pharmacist pharmacist){
        pharmacistMap.remove(pharmacist.getPersonDetails().getId());
    }

    public GenericDirectory<String, Pharmacist> getPharmacistMap() {
        return pharmacistMap;
    }
}
