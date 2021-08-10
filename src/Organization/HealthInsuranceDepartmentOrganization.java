/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organization;

import Enterprise.Enterprise;

/**
 *
 * @author Ankur Bywar
 */
public class HealthInsuranceDepartmentOrganization extends Organization {
    
    public HealthInsuranceDepartmentOrganization(String name, Enterprise enterprise) {
        super(name, enterprise, OrganizationType.HEALTH_INSURANCE_DEPARTMENT);
    }
    
}