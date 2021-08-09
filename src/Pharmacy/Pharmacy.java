/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import Medicine.Medicine;
import Personnel.Address;

/**
 *
 * @author Sravya
 */
public class Pharmacy {
    String pharmacyName;
    Address pharmacyAddress;
    Pharmacist pharmacist;
    Medicine medicine;

    public Pharmacy(
            String pharmacyName, 
            Address pharmacyAddress, 
            Pharmacist pharmacist, 
            Medicine medicine) {
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacist = pharmacist;
        this.medicine = medicine;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Address getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(Address pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }  
}
