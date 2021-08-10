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
public class PatientOrganization extends Organization {
    
    public PatientOrganization(String name, Enterprise enterprise) {
        super(name, enterprise, OrganizationType.PATIENT_ORGANIZATION);
    }
    
}
