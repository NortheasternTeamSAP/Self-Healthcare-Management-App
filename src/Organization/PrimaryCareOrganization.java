/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organization;

import Enterprise.Enterprise;
import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class PrimaryCareOrganization extends Organization {
    
    public PrimaryCareOrganization(String name, Enterprise enterprise, LocalDate organizationCreationDate) {
        super(name, enterprise, OrganizationType.PRIMARY_CARE, organizationCreationDate);
    }
    
}
