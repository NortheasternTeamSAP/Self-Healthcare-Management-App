/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organization;

import Enterprise.Enterprise;

/**
 *
 * @author sravy
 */
public class DeliveryDepartmentOrganization extends Organization{
    
    public DeliveryDepartmentOrganization(String name, Enterprise enterprise){
        super(name, enterprise, OrganizationType.DELIVERY_DEPARTMENT);
    }
}
