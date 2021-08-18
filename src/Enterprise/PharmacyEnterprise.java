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
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sravya
 */
public class PharmacyEnterprise extends Enterprise {
    
    HashMap<Medicine, Integer> medicineStockMap; // maps medicine to quantity
    private ArrayList<Order> currentOrders;
    
    
    public PharmacyEnterprise(String enterpriseName, Address enterpriseAddress){
        super(enterpriseName, enterpriseAddress, EnterpriseType.PHARMACY);
    }
    
    @Override
    public ArrayList<Organization.OrganizationType> getSupportedOrgTypes(){
        ArrayList<OrganizationType> types = new ArrayList<OrganizationType>();
        types.add(OrganizationType.MEDICINE_INVENTORY);
        types.add(OrganizationType.DELIVERY_DEPARTMENT);
        return types;
    }
    
    public void addMedicineStock(Medicine medicine, int quantity){
        this.medicineStockMap.put(medicine, quantity);
    }
    
    public HashMap<Medicine, Integer> getMedicineStockMap(){
        return medicineStockMap;
    }

    @Override
    public String toString(){
        return this.getEnterpriseName() + ", " + this.getEnterpriseAddress().getCity();
    }
}
