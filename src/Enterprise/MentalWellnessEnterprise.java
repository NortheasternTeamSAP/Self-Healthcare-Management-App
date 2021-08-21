/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

import Organization.OrganizationType;
import Personnel.Address;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class MentalWellnessEnterprise extends Enterprise {
     public MentalWellnessEnterprise(String enterpriseName, Address enterpriseAddress, LocalDate creationDate) {
        super(enterpriseName, enterpriseAddress, EnterpriseType.MENTAL_HEALTH, creationDate);
    }
     
    @Override
    public ArrayList<Organization.OrganizationType> getSupportedOrgTypes() {
        ArrayList<OrganizationType> types = new ArrayList<OrganizationType>();
        types.add(OrganizationType.PSYCHIATRY_DEPARTMENT);
        return types;
    }     
}
