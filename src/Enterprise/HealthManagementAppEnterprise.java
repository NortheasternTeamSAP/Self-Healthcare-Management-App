/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

import Personnel.Address;

/**
 *
 * @author Ankur Bywar
 */
public class HealthManagementAppEnterprise extends Enterprise {
    
    public HealthManagementAppEnterprise(String enterpriseName, Address enterpriseAddress) {
        super(enterpriseName, enterpriseAddress, EnterpriseType.HEALTH_MANAGEMENT_APP);
    }
    
}
