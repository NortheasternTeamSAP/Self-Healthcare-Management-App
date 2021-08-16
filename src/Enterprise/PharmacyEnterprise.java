/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

import Organization.OrganizationType;
import Personnel.Address;
import java.util.ArrayList;

/**
 *
 * @author Sravya
 */
public class PharmacyEnterprise extends Enterprise {
    
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
}
