/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

import Medicine.Medicine;
import Order.Order;
import Personnel.Address;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Sravya
 */
public class Pharmacy {
    String pharmacyName;
    Address pharmacyAddress;
    Pharmacist pharmacist;
    HashMap<Medicine, Integer> medicineStockMap; // maps medicine to quantity
    private ArrayList<Order> currentOrders;

    public Pharmacy(
            String pharmacyName, 
            Address pharmacyAddress, 
            Pharmacist pharmacist) {
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacist = pharmacist;
        this.medicineStockMap = new HashMap<>();
        this.currentOrders = new ArrayList<>();
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
    
    public void addMedicineStock(Medicine medicine, int quantity){
        this.medicineStockMap.put(medicine, quantity);
    }
    
    public HashMap<Medicine, Integer> getMedicineStockMap(){
        return medicineStockMap;
    }

    @Override
    public String toString(){
        return this.pharmacyName + ", " + this.pharmacyAddress.getCity();
    }
}
