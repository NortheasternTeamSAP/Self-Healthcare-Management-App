/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organization;

import Enterprise.Enterprise;

/**
 *
 * @author preet
 */
public class PsychiatristOrganization extends Organization{
     public PsychiatristOrganization(String name, Enterprise enterprise) {
        super(name, enterprise, OrganizationType.PSYCHIATRY_DEPARTMENT);
    }      
}
