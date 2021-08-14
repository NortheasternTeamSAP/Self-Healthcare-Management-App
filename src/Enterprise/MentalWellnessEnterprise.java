/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

import Personnel.Address;

/**
 *
 * @author preet
 */
public class MentalWellnessEnterprise extends Enterprise {
     public MentalWellnessEnterprise(String enterpriseName, Address enterpriseAddress) {
        super(enterpriseName, enterpriseAddress, EnterpriseType.MENTAL_HEALTH);
    }
}
