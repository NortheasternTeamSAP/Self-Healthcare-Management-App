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
 * @author sravy
 */
public class DeliveryDepartmentOrganization extends Organization{
    
    public DeliveryDepartmentOrganization(String name, Enterprise enterprise, LocalDate organizationCreationDate){
        super(name, enterprise, OrganizationType.DELIVERY_DEPARTMENT, organizationCreationDate);
    }
}
