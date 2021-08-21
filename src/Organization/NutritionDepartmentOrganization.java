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
 * @author preet
 */

public class NutritionDepartmentOrganization extends Organization {
    
    public NutritionDepartmentOrganization(String name, Enterprise enterprise, LocalDate organizationCreationDate) {
        super(name, enterprise, OrganizationType.NUTRITION_DEPARTMENT, organizationCreationDate);
    }   
}
