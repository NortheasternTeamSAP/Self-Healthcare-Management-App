 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

import Organization.Organization;
import Organization.OrganizationType;
import Personnel.Address;
import Utils.ConsoleLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Ankur Bywar
 */
public abstract class Enterprise {
    
    private String enterpriseName;
    private Address enterpriseAddress;
    private EnterpriseType enterpriseType;
    private int enterpriseId;
    private HashMap<Integer, Organization> organizations;
    
    static int countId = 1;
    
    ConsoleLogger log = ConsoleLogger.getLogger();

    public Enterprise(String enterpriseName, Address enterpriseAddress, EnterpriseType enterpriseType) {
        this.enterpriseName = enterpriseName;
        this.enterpriseAddress = enterpriseAddress;
        this.enterpriseType = enterpriseType;
        organizations = new HashMap<>();
        this.enterpriseId = countId++;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void addOrganization(Organization organization) {
        if (organization == null) {
            log.error("Organization is null. Cannot add to enterprise");
            return;
        }
        
        if (organizations.containsKey(organization.getOrganizationId())) {
            log.error("Organization with id " + organization.getOrganizationId() + " already exists in enterprise");
            return;
        }
        
        organizations.put(organization.getOrganizationId(), organization);
    }
    
    public Organization getOrganization(int id) {
        return organizations.get(id);
    }
    
    public Address getEnterpriseAddress() {
        return enterpriseAddress;
    }
    
    public List<Organization> getOrganizations() {
       
        return new ArrayList<>(organizations.values());
    }
    
    // derived classes should implement as required
    public ArrayList<OrganizationType> getSupportedOrgTypes() {
        return null;
    }        

}
