 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

import Organization.Organization;
import Organization.OrganizationType;
import static Organization.OrganizationType.ADMIN_ORGANIZATION;
import static Organization.OrganizationType.DELIVERY_DEPARTMENT;
import static Organization.OrganizationType.GYM;
import static Organization.OrganizationType.HEALTH_INSURANCE_DEPARTMENT;
import static Organization.OrganizationType.LABORATORY;
import static Organization.OrganizationType.MEDICINE_INVENTORY;
import static Organization.OrganizationType.NUTRITION_DEPARTMENT;
import static Organization.OrganizationType.PATIENT_ORGANIZATION;
import static Organization.OrganizationType.PRIMARY_CARE;
import static Organization.OrganizationType.PSYCHIATRY_DEPARTMENT;
import Personnel.Address;
import Utils.ConsoleLogger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    private LocalDate enterpriseCreationDate;
    
    static int countId = 1;
    
    ConsoleLogger log = ConsoleLogger.getLogger();

    public Enterprise(String enterpriseName, Address enterpriseAddress, EnterpriseType enterpriseType, LocalDate enterpriseCreationDate) {
        this.enterpriseName = enterpriseName;
        this.enterpriseAddress = enterpriseAddress;
        this.enterpriseType = enterpriseType;
        this.enterpriseCreationDate = enterpriseCreationDate;
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
    
    public LocalDate getEnterpriseCreationDate() {
        return this.enterpriseCreationDate;
    }
    
    // derived classes should implement as required
    public List<OrganizationType> getSupportedOrgTypes() {
        switch (this.enterpriseType) {
            case HEALTH_MANAGEMENT_APP:
                return Arrays.asList(ADMIN_ORGANIZATION, PATIENT_ORGANIZATION);
            case HOSPITAL:
                return Arrays.asList(PRIMARY_CARE, LABORATORY);
            case INSURANCE_COMPANY:
                return Arrays.asList(HEALTH_INSURANCE_DEPARTMENT);
            case PHARMACY:
                return Arrays.asList(MEDICINE_INVENTORY, DELIVERY_DEPARTMENT);
            case PHYSICAL_WELLNESS:
                return Arrays.asList(NUTRITION_DEPARTMENT, GYM);
            case MENTAL_HEALTH:
                return Arrays.asList(PSYCHIATRY_DEPARTMENT);
        }
        
        return null;
    }        

}
