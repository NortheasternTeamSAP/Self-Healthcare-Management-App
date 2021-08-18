/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import DataStore.GenericDirectory;
import Enterprise.PharmacyEnterprise;
import Medicine.Medicine;
import Medicine.MedicineDirectory;
import Personnel.Address;

/**
 *
 * @author Sravya
 */
public class PharmacyDirectory {
    public  GenericDirectory<String, PharmacyEnterprise> pharmacyMap; //maps String Pharmacy ID to Pharmacy
    private int id;
    
    public PharmacyDirectory(){
        this.pharmacyMap = new GenericDirectory<>();
        id = 0;
    }
    
    public PharmacyEnterprise addPharmacy(
                                String pharmacyName,
                                Address pharmacyAddress){
        
        PharmacyEnterprise pharmacy = new PharmacyEnterprise(pharmacyName, pharmacyAddress);
        pharmacyMap.add(Integer.toString(id), pharmacy);
        id += 1;
        return pharmacy;
    }  
    
    public void deletePharmacy(PharmacyEnterprise pharmacy){
        pharmacyMap.remove(Integer.toString(id));
    }

    public GenericDirectory<String, PharmacyEnterprise> getPharmacyMap() {
        return pharmacyMap;
    }

    public void setPharmacyMap(GenericDirectory<String, PharmacyEnterprise> pharmacyMap) {
        this.pharmacyMap = pharmacyMap;
    }
    
}
