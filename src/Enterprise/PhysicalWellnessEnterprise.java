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
 * @author preet
 */

public class PhysicalWellnessEnterprise extends Enterprise {
    
    public PhysicalWellnessEnterprise(String enterpriseName, Address enterpriseAddress) {
        super(enterpriseName, enterpriseAddress, EnterpriseType.PHYSICAL_WELLNESS);
    }
    
    @Override
    public ArrayList<Organization.OrganizationType> getSupportedOrgTypes() {
        ArrayList<OrganizationType> types = new ArrayList<OrganizationType>();
        types.add(OrganizationType.NUTRITION_DEPARTMENT);
        types.add(OrganizationType.GYM);        
        return types;
    }         
    
}