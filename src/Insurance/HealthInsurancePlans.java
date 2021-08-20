/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insurance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mrs.katey
 */
public class HealthInsurancePlans {
    
    Map<String, InsurancePlanDetails> healthInsurancePlans = new HashMap<>();
    
    public HealthInsurancePlans() {
        healthInsurancePlans.put("Shared Deductible Plan", new InsurancePlanDetails("Shared Deductible Plan", 33, 2000, "In network only"));
        healthInsurancePlans.put("Health Savings Plan", new InsurancePlanDetails("Health Savings Plan", 91, 4000, "In network only"));
        healthInsurancePlans.put("Standard Plan", new InsurancePlanDetails("Standard Plan", 40, 3500, "In network only"));
    }
    
    public Set<String> getALLPlanNames() {
        return healthInsurancePlans.keySet();
    }
    
    public InsurancePlanDetails getPlanDetails(String planName) {
        return healthInsurancePlans.get(planName);
    }
}
