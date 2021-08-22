/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

import Medicine.Medicine;
import Order.Order;
import Organization.OrganizationType;
import Personnel.Address;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sravya
 */
public class PharmacyEnterprise extends Enterprise {
    
    HashMap<Medicine, Integer> medicineStockMap; // maps medicine to quantity
    private ArrayList<Order> currentOrders;
    
    
    public PharmacyEnterprise(String enterpriseName, Address enterpriseAddress, LocalDate creationDate){
        super(enterpriseName, enterpriseAddress, EnterpriseType.PHARMACY, creationDate);
        medicineStockMap = new HashMap<>();
    }
    
    @Override
    public ArrayList<Organization.OrganizationType> getSupportedOrgTypes(){
        ArrayList<OrganizationType> types = new ArrayList<OrganizationType>();
        types.add(OrganizationType.MEDICINE_INVENTORY);
        types.add(OrganizationType.DELIVERY_DEPARTMENT);
        return types;
    }
    
    public void addMedicineStock(Medicine medicine, int newquantity){
        Integer oldQuantity = this.medicineStockMap.get(medicine);
        if (oldQuantity == null) {
            oldQuantity = 0;
        }
        this.medicineStockMap.put(medicine, oldQuantity + newquantity);
    }
    
    public void deleteMedicine(Medicine medicine) {
        this.medicineStockMap.remove(medicine);
    }
    
    public HashMap<Medicine, Integer> getMedicineStockMap(){
        return medicineStockMap;
    }

    @Override
    public String toString(){
        return this.getEnterpriseName() + ", " + this.getEnterpriseAddress().getCity();
    }
}
