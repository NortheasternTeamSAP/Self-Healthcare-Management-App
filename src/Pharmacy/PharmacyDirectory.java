/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import DataStore.GenericDirectory;
import Medicine.Medicine;
import Medicine.MedicineDirectory;
import Personnel.Address;

/**
 *
 * @author Sravya
 */
public class PharmacyDirectory {
    public static GenericDirectory<String, Pharmacy> pharmacyMap;
    private int id;
    
    public PharmacyDirectory(){
        this.pharmacyMap = new GenericDirectory<>();
        id = 0;
    }
    
    public Pharmacy addPharmacy(
                                String pharmacyName,
                                Address pharmacyAddress,
                                Pharmacist pharmacist){
        
        Pharmacy pharmacy = new Pharmacy(pharmacyName, pharmacyAddress, pharmacist);
        PharmacyDirectory.pharmacyMap.add(Integer.toString(id), pharmacy);
        id += 1;
        return pharmacy;
    }  
    
    public void deletePharmacy(Pharmacy pharmacy){
        PharmacyDirectory.pharmacyMap.remove(Integer.toString(id));
    }

    public static GenericDirectory<String, Pharmacy> getPharmacyMap() {
        return pharmacyMap;
    }

    public static void setPharmacyMap(GenericDirectory<String, Pharmacy> pharmacyMap) {
        PharmacyDirectory.pharmacyMap = pharmacyMap;
    }
    
}
