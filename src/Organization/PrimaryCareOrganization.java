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
public class PrimaryCareOrganization extends Organization {
    
    public PrimaryCareOrganization(String name, Enterprise enterprise) {
        super(name, enterprise, OrganizationType.PRIMARY_CARE);
    }
    
}